package com.intention.sqtwin.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;

/**
 * @data 2017/4/17 0017
 * @aurher Administrator
 */
public class AmountView extends LinearLayout implements View.OnClickListener, TextWatcher {

    private static final String TAG = "AmountView";
    private int amount = 1; //购买数量
    private int goods_storage = 100; //商品库存

    private OnAmountChangeListener mListener;

//    private EditText etAmount;
    private TextView etAmount;
    private Button btnDecrease;
    private Button btnIncrease;

    public AmountView(Context context) {
        this(context, null);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public AmountView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, defStyleAttr);
//        this(context, null, null);
        init(context,attrs);
    }

    public AmountView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.view_amount, this);
//        etAmount = (EditText) findViewById(R.id.etAmount);
        etAmount = (TextView) findViewById(R.id.etAmount);
        btnDecrease = (Button) findViewById(R.id.btnDecrease);
        btnIncrease = (Button) findViewById(R.id.btnIncrease);
        btnDecrease.setOnClickListener(this);
        btnIncrease.setOnClickListener(this);
//        etAmount.addTextChangedListener(this);
//        etAmount.clearFocus();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.AmountView);
        float btWidTh = obtainStyledAttributes.getDimension(R.styleable.AmountView_btnWidth,  getResources().getDimension(R.dimen.x70));
        float tvWidTh = obtainStyledAttributes.getDimension(R.styleable.AmountView_tvWidth,  getResources().getDimension(R.dimen.x70));
        float btTextSize = obtainStyledAttributes.getDimension(R.styleable.AmountView_btnTextSize,  getResources().getDimension(R.dimen.x34));
        float tvTextSize = obtainStyledAttributes.getDimension(R.styleable.AmountView_tvTextSize,  getResources().getDimension(R.dimen.x34));
        btnDecrease.setTextSize(btTextSize);
        btnIncrease.setTextSize(btTextSize);
        etAmount.setTextSize(tvTextSize);

        ViewGroup.LayoutParams layoutParams = btnDecrease.getLayoutParams();
        layoutParams.width = (int) btWidTh;
        layoutParams.height = (int) btWidTh;
        btnDecrease.setLayoutParams(layoutParams);


        ViewGroup.LayoutParams layoutParams1 = btnIncrease.getLayoutParams();
        layoutParams1.width = (int) btWidTh;
        layoutParams1.height = (int) btWidTh;
        btnIncrease.setLayoutParams(layoutParams1);

        ViewGroup.LayoutParams layoutParams2 = etAmount.getLayoutParams();
        layoutParams2.width = (int) tvWidTh;
        layoutParams2.height = (int) tvWidTh;
        etAmount.setLayoutParams(layoutParams2);

        obtainStyledAttributes.recycle();
    }

    public int getAmount() {
        return Integer.parseInt(etAmount.getText().toString());
    }

    public void InitEtAmout(String num) {
        etAmount.setText(String.valueOf(num));
    }

    public void setOnAmountChangeListener(OnAmountChangeListener onAmountChangeListener) {
        this.mListener = onAmountChangeListener;
    }

    public void setGoods_storage(int goods_storage) {
        this.goods_storage = goods_storage;
    }

    public int getGoods_storage() {
        return goods_storage;
    }

    @Override
    public void onClick(View v) {
        etAmount.clearFocus();
        switch (v.getId()) {
            case R.id.btnDecrease:
                if (amount > 1) {
                    amount--;
                    etAmount.setText(amount + "");
                }
                break;
            case R.id.btnIncrease:
                if (amount < goods_storage) {
                    amount++;
                    etAmount.setText(amount + "");
                }
                break;
        }
        LogUtils.logd("ShoCartAdapter" + "执行到这一步了");
        if (mListener != null) {
            LogUtils.logd("ShoCartAdapter" + "接口监听了");
            mListener.onAmountChange(this, amount);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (TextUtils.isEmpty(s.toString())) {
            etAmount.setText("1");
            amount = 1;
//            etAmount.setSelection(etAmount.getText().length());
            return;
        }

        String SPut = s.toString();
        while (SPut.startsWith("0")&&SPut.length()>=2) {
            SPut = SPut.substring(1);
        }
        amount = Integer.valueOf(s.toString());
//        etAmount.setText(amount + "");
        if (amount > goods_storage) {
            etAmount.setText(goods_storage + "");
            return;
        }
        if (amount == 0) {

            etAmount.setText("1");
            amount = 1;
//            etAmount.setSelection(etAmount.getText().length());
        }

        if (mListener != null) {
            LogUtils.logd("ShoCartAdapter---Edittext" + "接口监听了");
            mListener.onAmountChange(this, amount);
        }
    }


    public interface OnAmountChangeListener {
        void onAmountChange(View view, int amount);
    }

}
