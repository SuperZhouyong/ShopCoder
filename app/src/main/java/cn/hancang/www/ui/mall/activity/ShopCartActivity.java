package cn.hancang.www.ui.mall.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.bean.DeleteAllShopCartBean;
import com.intention.sqtwin.bean.DeleteGoodsBean;

import java.math.BigDecimal;
import java.util.List;

import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.ShopCartGoodsBean;
import cn.hancang.www.ui.main.activity.MainActivity;
import cn.hancang.www.ui.mall.contract.ShopCartContract;
import cn.hancang.www.ui.mall.model.ShopCartModel;
import cn.hancang.www.ui.mall.presenter.ShopCartPresenter;
import cn.hancang.www.utils.checkbox.SmoothCheckBox;
import cn.hancang.www.widget.conmonWidget.LoadingTip;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 绝无Bug
 * Data：2018/5/18 0018-上午 11:13
 * Blog：Super简单
 * Author: ZhouYong
 */

public class ShopCartActivity extends BaseActivity<ShopCartPresenter, ShopCartModel> implements SmoothCheckBox.OnCheckedChangeListener, ShopCartContract.View, LoadingTip.onReloadListener, View.OnClickListener {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    @BindView(R.id.left_title)
    TextView leftTitle;
    @BindView(R.id.center_title)
    TextView centerTitle;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.rel_search)
    RelativeLayout relSearch;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.sCheckBox)
    SmoothCheckBox sCheckBox;
    @BindView(R.id.tv_price_num)
    TextView tvPriceNum;
    @BindView(R.id.rel_bottom)
    RelativeLayout relBottom;
    @BindView(R.id.mLRecyclerView)
    LRecyclerView mLRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip loadingTip;
    private LRecyclerViewAdapter mLadapter;
    private CommonRecycleViewAdapter<ShopCartGoodsBean.DataBean.CartBean> mAdapter;
    private SparseArray<String> mCheckItem;
    private int currentDeletePos;

    @Override
    public int getLayoutId() {
        return R.layout.activity_shopcart;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        mCheckItem = new SparseArray<>();
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("购物车");
        relSearch.setVisibility(View.GONE);
        sCheckBox.setOnCheckedChangeListener(this);
        mAdapter = new CommonRecycleViewAdapter<ShopCartGoodsBean.DataBean.CartBean>(this, R.layout.item_shopcart) {
            @Override
            public void convert(ViewHolderHelper helper, final ShopCartGoodsBean.DataBean.CartBean shopCartGoodsBean, final int position) {
//                helper.setVisible(R.id.amount_view, false);
//                helper.setVisible(R.id.iv_delete, false);
//                    helper.getView(R.id.sCheckBox)
                helper.setText(R.id.tv_goods_name, shopCartGoodsBean.getGoods_name());
                helper.setText(R.id.tv_goods_price, "￥" + shopCartGoodsBean.getPrice());
                TextView tvPrice = helper.getView(R.id.tv_goods_price);
                helper.setImageRoundTwoUrl(R.id.iv_goods_pic, shopCartGoodsBean.getImage());
                updateTextColor(tvPrice, 0, 0);
                SmoothCheckBox smoothCheckBox = helper.getView(R.id.sCheckBox);
                smoothCheckBox.setOnCheckedChangeListener(new SmoothCheckBox.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(SmoothCheckBox checkBox, boolean isChecked) {
                        if (isChecked && mCheckItem.get(shopCartGoodsBean.getGoods_id()) == null) {
                            BigDecimal oneBig = new BigDecimal(Float.parseFloat(shopCartGoodsBean.getPrice()));
                            BigDecimal twoBig = new BigDecimal(shopCartGoodsBean.getCount());
                            BigDecimal multiply = oneBig.multiply(twoBig);
                            mCheckItem.append(shopCartGoodsBean.getGoods_id(), String.valueOf(multiply));
                        } else if (!isChecked && mCheckItem.get(shopCartGoodsBean.getGoods_id()) != null) {
                            mCheckItem.remove(shopCartGoodsBean.getGoods_id());
//                            sCheckBox.setChecked(false);
                        }
                        showPriceTotle();

                    }
                });
                smoothCheckBox.setChecked(mCheckItem.get(shopCartGoodsBean.getGoods_id()) != null);
                helper.setText(R.id.tv_goods_num, "x " + shopCartGoodsBean.getCount());

                helper.setOnClickListener(R.id.iv_delete, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPresenter.getDeleteGoodsRequest(shopCartGoodsBean.getGoods_id());
                        currentDeletePos = position;
                    }
                });

            }
        };
        mLadapter = new LRecyclerViewAdapter(mAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLRecyclerView.setAdapter(mLadapter);
        mLRecyclerView.setPullRefreshEnabled(false);
        mLRecyclerView.setLoadMoreEnabled(false);

        View footView = getLayoutInflater().inflate(R.layout.item_shopcart_foot, null);
        footView.findViewById(R.id.rel_delet_all).setOnClickListener(this);
        footView.findViewById(R.id.rel_goto_shop).setOnClickListener(this);

        mLadapter.addFooterView(footView);
//        mAdapter.add(new ShopCartGoodsBean());
        mPresenter.getShopCartInfoRequest();
//        sCheckBox.setOnCheckedChangeListener(this);
    }


    @OnClick({R.id.rel_back, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.tv_confirm:
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < mCheckItem.size(); i++) {
//                    int i1 = mCheckItem.keyAt(0);
                    if (i != mCheckItem.size() - 1) {
                        stringBuilder.append(mCheckItem.keyAt(0) + ",");
                    } else
                        stringBuilder.append(mCheckItem.keyAt(0));
                }
                String s = stringBuilder.toString();
                if (TextUtils.isEmpty(s)) {
                    showShortToast("请选择结算的商品");
                    return;
                }
                ConfirmOrderActivity.gotoConfirmOrderActivity(this, s, "", AppConstant.twoMessage);
                break;


        }
    }

    @Override
    public void onCheckedChanged(SmoothCheckBox checkBox, boolean isChecked) {
        if (isChecked) {
            List<ShopCartGoodsBean.DataBean.CartBean> dataList = mAdapter.getDataList();
            for (int i = 0; i < dataList.size(); i++) {
                if (mCheckItem.get(dataList.get(i).getGoods_id()) == null) {
                    BigDecimal oneBig = new BigDecimal(Float.parseFloat(dataList.get(i).getPrice()));
                    BigDecimal twoBig = new BigDecimal(dataList.get(i).getCount());
                    BigDecimal multiply = oneBig.multiply(twoBig);

                    mCheckItem.append(dataList.get(i).getGoods_id(), String.valueOf(multiply));
                }
            }
            mAdapter.notifyDataSetChanged();
        } else {
            if (mCheckItem.size() != 0) {
                mCheckItem.clear();
                mAdapter.notifyDataSetChanged();

            }
        }
        showPriceTotle();
    }

    // 得到合适的金额  tv_price_num
    private void showPriceTotle() {
        Float mTotlePrice = Float.valueOf(0);
        for (int i = 0; i < mCheckItem.size(); i++) {
            String s = mCheckItem.valueAt(i);
            if (!TextUtils.isEmpty(s))
                mTotlePrice += Float.parseFloat(s);
        }
        if (mTotlePrice != null)
            tvPriceNum.setText("￥" + mTotlePrice);


    }

    @Override
    public void StartLoading(String RequestId) {
        if (AppConstant.oneMessage.equals(RequestId)) {
            loadingTip.setNoLoadTip(LoadingTip.NoloadStatus.StartLoading);
        }
    }

    @Override
    public void showLoading(String RequestId, String title) {

    }

    @Override
    public void stopLoading(String RequestId) {

    }

    @Override
    public void showErrorTip(String RequestId, String msg) {
        if (AppConstant.oneMessage.equals(RequestId)) {
            loadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            loadingTip.setOnReloadListener(this);
        }
    }

    @Override
    public void returnShopCartInfo(ShopCartGoodsBean shopCartGoodsBean) {
        if (!shopCartGoodsBean.isIs_success()) {
            showShortToast(shopCartGoodsBean.getMessage());
            return;
        }
        if (shopCartGoodsBean.getData().getCart() == null || shopCartGoodsBean.getData().getCart().size() == 0) {
            loadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoShopCart);

        }
        if (loadingTip.getVisibility() == View.VISIBLE)
            loadingTip.setViewGone();

        mAdapter.addAll(shopCartGoodsBean.getData().getCart());
    }

    @Override
    public void returnDeleteGoodsInfo(DeleteGoodsBean deleteGoodsBean) {
        if (!deleteGoodsBean.isIs_success()) {
            showShortToast("删除失败，请稍后再试");
            return;
        }
        ShopCartGoodsBean.DataBean.CartBean cartBean = mAdapter.get(currentDeletePos);
        if (mCheckItem.get(cartBean.getGoods_id()) == null) {

        } else {
            mCheckItem.remove(cartBean.getGoods_id());
            showPriceTotle();
        }
        if (mAdapter.getDataList().size() > currentDeletePos)
            mAdapter.removeAt(currentDeletePos);
        if (mAdapter.getDataList().size() == 0) {

            loadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoShopCart);
            loadingTip.setOnReloadListener(new LoadingTip.onReloadListener() {
                @Override
                public void reloadLodTip() {
                    MainActivity.startAction(ShopCartActivity.this);
                }
            });

        }


    }

    @Override
    public void returnDeleteAllGoodsInfo(DeleteAllShopCartBean deleteAllShopCartBean) {
        if (!deleteAllShopCartBean.isIs_success()) {
            showShortToast("删除失败，请稍后再试");
            return;
        }
        mAdapter.clear();
        loadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoShopCart);
        loadingTip.setOnReloadListener(new LoadingTip.onReloadListener() {
            @Override
            public void reloadLodTip() {
                MainActivity.startAction(ShopCartActivity.this);
            }
        });
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getShopCartInfoRequest();
    }

    private void updateTextColor(TextView tv, int starts, int end) {
        SpannableString spannedString = new SpannableString(tv.getText().toString());
//        spannedString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.app_main)), starts[i], starts[i + 1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannedString.setSpan(new AbsoluteSizeSpan((int) mContext.getResources().getDimension(R.dimen.x20)), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tv.setText(spannedString);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rel_delet_all:
                mPresenter.getDeleteAllGoodsRequest();
                break;
            case R.id.rel_goto_shop:
                MainActivity.startAction(this);
                break;
        }
    }
}
