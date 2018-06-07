package cn.hancang.www.widget.table;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.hancang.www.R;

import cn.hancang.www.widget.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_DRAGGING;
import static android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE;
import static android.support.v7.widget.RecyclerView.SCROLL_STATE_SETTLING;

/**
 * Created by Administrator on 2017/12/8 0008.
 */

public abstract class AbstractPanelListAdapter1 {

    private Context context;
    /**
     * 整个页面的所有布局
     */
    private PanelListLayout pl_root;//外层的根布局
    private TextView tv_title;//左上角的title
    private LinearLayout ll_row;//上方的表头
    private RecyclerView lv_column;//左边的表头
    private RecyclerView lv_content;//中间的内容部分
    private LinearLayout ll_contentItem;//中间的内容部分的子布局
    private RecyclerView.Adapter contentAdapter;// 内容的adapter
    private RecyclerView.Adapter columnAdapter;// 纵向表头adapter
    /**
     * 左上角的标题
     */
    private String title;

    private String titleColor = "#FFFFFF";//default color of title
    private String columnColor = "#FFFFFF";//default color of column
    private String rowColor = "#FFFFFF";//default color of title
    private String dividerLineColor = "#F4F4F4";//default color of title
    /**
     * 标题的宽和高,同时也是列表头的宽和列表头的高
     */
    private int titleWidth;
    private int titleHeight;
    private int columnItemHeight = 100;

    private MyHorizontalScrollView mhsv_row;
    private MyHorizontalScrollView mhsv_content;

    /**
     * 两个监听器，分别控制水平和垂直方向上的同步滑动
     */
    private HorizontalScrollListener horizontalScrollListener = new HorizontalScrollListener();
    private VerticalScrollListener verticalScrollListener = new VerticalScrollListener();
    private int initPosition = 0;//列表显示的初始值，默认第一条数据显示在最上面
    private SpacesItemDecoration columnDivider = new SpacesItemDecoration(2);

    private List<String> columnDataList;
    private List<String> rowDataList;
    /**
     * 标志位，是否使用了默认的column实现
     */
    private boolean defaultColumn = false;

    public List<String> getRowDataList() {
        return rowDataList;
    }

    private boolean isShouldBottomTitle;

    public void setShouldBottomTitle(boolean shouldBottomTitle) {
        isShouldBottomTitle = shouldBottomTitle;
    }

    private Drawable rowDivider;
    /**
     * 默认关闭下拉刷新
     */
    private boolean swipeRefreshEnable = false;
    /**
     * 判断是否是加载更多
     */
    private boolean isLoadingMore;
    //    尾部视图
    private View footerView;

    private AbstractPanelListAdapter.OnRefreshListener mOnRefreshListener;

    /**
     * 初始化总Adapter，加载数据到视图
     */
    void initAdapter() {
        contentAdapter = getContentAdapter();

        if (contentAdapter == null) {
            try {
                throw new Exception("content adapter can NOT be null");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        reorganizeViewGroup();

        mhsv_row.setOnHorizontalScrollListener(horizontalScrollListener);
        mhsv_content.setOnHorizontalScrollListener(horizontalScrollListener);

        lv_content.addOnScrollListener(verticalScrollListener);
        lv_column.addOnScrollListener(verticalScrollListener);
    }

    /**
     * 核心代码：
     * 整理重组整个表的布局
     * <p>
     * 主要包含4个部分
     * 1. title
     * 2. row
     * 3. column
     * 4. content
     */
    private void reorganizeViewGroup() {

        lv_content.setLayoutManager(new LinearLayoutManager(context));
        lv_content.setAdapter(contentAdapter);
        lv_content.addItemDecoration(columnDivider);
        lv_content.setVerticalScrollBarEnabled(false);

        // clear root viewGroup
        pl_root.removeView(lv_content);

        // 1. title (TextView --> PanelListLayout)
        tv_title = new TextView(context);
        tv_title.setText(title);
        tv_title.setTextColor(context.getResources().getColor(R.color.font_1));
        tv_title.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.x28));
        tv_title.setGravity(Gravity.CENTER);
        tv_title.setBackgroundColor(isShouldBottomTitle ? context.getResources().getColor(R.color.app_bottom_colour) : Color.parseColor(titleColor));
//        tv_title.setBackgroundColor(context.getResources().getColor(R.color.black));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            tv_title.setId(View.generateViewId());//设置一个随机id，这样可以保证不冲突
        }
        RelativeLayout.LayoutParams lp_tv_title = new RelativeLayout.LayoutParams(titleWidth, titleHeight);
        pl_root.addView(tv_title, lp_tv_title);

        // 2. 横向表头row（LinearLayout --> MyHorizontalScrollView --> PanelListLayout）
        ll_row = new LinearLayout(context);
//        ll_row.setBackgroundColor(context.getResources().getColor(R.color.black));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        ll_row.setLayoutParams(lp);
        mhsv_row = new MyHorizontalScrollView(context);
//        mhsv_row.setBackgroundColor(context.getResources().getColor(R.color.black));
        mhsv_row.setHorizontalScrollBarEnabled(false);
        mhsv_row.setOverScrollMode(View.OVER_SCROLL_NEVER);//去除滑动到边缘时出现的阴影
        mhsv_row.addView(ll_row);//暂时先不给ll_row添加子view，等布局画出来了再添加
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mhsv_row.setId(View.generateViewId());
        }
        RelativeLayout.LayoutParams lp_mhsv_row = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, titleHeight);
        lp_mhsv_row.addRule(RelativeLayout.RIGHT_OF, tv_title.getId());
        lp_mhsv_row.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        pl_root.addView(mhsv_row, lp_mhsv_row);

        // 3.加个分割线
        ImageView imageView = new ImageView(context);
        imageView.setBackgroundColor(Color.parseColor(dividerLineColor));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            imageView.setId(View.generateViewId());
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2);
        layoutParams.addRule(RelativeLayout.BELOW, tv_title.getId());
        pl_root.addView(imageView, layoutParams);

        // 4.上拉加载更多布局 footView
        footerView = getFooterView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            if (footerView != null)
                footerView.setId(View.generateViewId());
        }

        // 5. 纵向表头column （ListView --> PanelListLayout）
        lv_column = new RecyclerView(context);
        lv_column.setLayoutManager(new LinearLayoutManager(context));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            lv_column.setId(View.generateViewId());
        }
        lv_column.setVerticalScrollBarEnabled(false);//去掉滚动条
        RelativeLayout.LayoutParams lp_lv_column = new RelativeLayout.LayoutParams(titleWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        lp_lv_column.addRule(RelativeLayout.BELOW, imageView.getId());
        if (footerView != null)
            lp_lv_column.addRule(RelativeLayout.ABOVE, footerView.getId());
        pl_root.addView(lv_column, lp_lv_column);

        // 6. 内容content (ListView --> MyHorizontalScrollView --> SwipeRefreshLayout --> PanelListLayout)
        mhsv_content = new MyHorizontalScrollView(context);
        // todo   lv_content 已经有父类了
        ViewGroup parent = (ViewGroup) lv_content.getParent();
        if (parent != null)
            parent.removeAllViews();
        mhsv_content.addView(lv_content);//因为 lv_content 在 xml 文件中已经设置了 layout 为 match_parent，所以这里add时不需要再加 LayoutParameter 对象
        mhsv_content.setHorizontalScrollBarEnabled(false);
        mhsv_content.setVerticalScrollBarEnabled(false);
        mhsv_content.setOverScrollMode(View.OVER_SCROLL_NEVER);//去除滑动到边缘时出现的阴影
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mhsv_content.setId(View.generateViewId());
        }

        // 7.设置content内容布局
        RelativeLayout.LayoutParams lp_srl = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        lp_srl.addRule(RelativeLayout.RIGHT_OF, lv_column.getId());
        if (footerView != null)
            lp_srl.addRule(RelativeLayout.ABOVE, footerView.getId());
        lp_srl.addRule(RelativeLayout.BELOW, imageView.getId());
        pl_root.addView(mhsv_content, lp_srl);
        if (footerView != null) {


            // 8.加载更多布局的LayoutParams
            RelativeLayout.LayoutParams lp_footerView = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) context.getResources().getDimension(R.dimen.y60));
            lp_footerView.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            pl_root.addView(footerView, lp_footerView);
            footerView.setVisibility(View.GONE);
        }
        // 发一个消息出去。当布局渲染完成之后会执行消息内容，此时
        pl_root.post(new Runnable() {
            @Override
            public void run() {
                RelativeLayout childAt = (RelativeLayout) lv_content.getChildAt(0);
                ll_contentItem = (LinearLayout) childAt.getChildAt(0);//获得content的第一个可见item
                initColumnLayout();// 纵向表头
                initRowLayout();// 横向表头
                // 当ListView绘制完成后设置初始位置，否则ll_contentItem会报空指针
//                lv_content.smoothScrollToPosition(initPosition);
//                lv_column.smoothScrollToPosition(initPosition);
            }
        });
    }

    /**
     * 加在更多的布局
     *
     * @return
     */
    protected abstract View getFooterView();

    /**
     * 更新ContentList数据后需要调用此方法来刷新列表
     * <p>
     * 该方法会判断是否使用了默认的纵向表头，如果是，则自动更新表头
     * 如果不是，则不更新纵向表头，交给开发者自己去更新
     * 开发者可以调用{@link #getColumnAdapter()}以获得columnAdapter
     */
    public void notifyDataSetChanged() {
        // 先刷新lv_content的数据，然后根据判断决定是否要刷新表头的数据
        contentAdapter.notifyDataSetChanged();
        columnAdapter.notifyDataSetChanged();
    }

    /**
     * 初始化横向表头的布局，必须在所有的布局都载入完之后才能调用
     * <p>
     * must be called in pl_root.post();
     */
    private void initRowLayout() {
        if (rowDataList == null) {
            Log.e("PanelList", "custom Row data list is strongly recommended! Call setRowDataList(List<String> rowDataList) in your panel adapter");
        }
        int rowCount = ll_contentItem.getChildCount();

        List<String> rowDataList1 = getRowDataList(rowCount);

        //分隔线的设置，如果content的item设置了分割线，那row使用相同的分割线，除非单独给row设置了分割线
        ll_row.setBackgroundColor(isShouldBottomTitle ? context.getResources().getColor(R.color.app_bottom_colour) : Color.parseColor(rowColor));
//        ll_row.setBackgroundColor(context.getResources().getColor(R.color.black));
        // 获得row一共有多少个item，然后使用循环往里面添加对应个数个TextView（简单粗暴）
        for (int i = 0; i < rowDataList1.size(); i++) {
            View contentItem = ll_contentItem.getChildAt(i);// 获得item的item，以便获取宽度
            TextView rowItem = new TextView(context);
            rowItem.setText(rowDataList1.get(i));//设置文字
            rowItem.setWidth(((int) context.getResources().getDimension(R.dimen.x160)));//设置宽度
            rowItem.setHeight(titleHeight);//设置高度
            rowItem.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.x28));
            rowItem.setTextColor(context.getResources().getColor(R.color.font_1));
            rowItem.setGravity(Gravity.CENTER);
            ll_row.addView(rowItem);
        }
    }

    /**
     * 返回横向表头的内容列表
     * <p>
     * 如果设置了自定义的表头内容，则直接返回引用
     * 如果用户没设置，则根据传进来的count数生成一个默认表头
     */
    private List<String> getRowDataList(int count) {
        if (rowDataList == null) {
            List<String> defaultRowDataList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String s = "Row" + i;
                defaultRowDataList.add(s);
            }
            return defaultRowDataList;
        } else {
            return rowDataList;
        }
    }

    private void initColumnLayout() {
        columnAdapter = getColumnAdapter();
        lv_column.setAdapter(columnAdapter);
//        lv_column.addItemDecoration(columnDivider);
    }

    /**
     * 返回纵向表头的数据列表
     * 如果开发者没有自定义纵向表头，则生成默认的表头，其内容为1~n，并且将标志位置true
     * 方便{@link #notifyDataSetChanged()}方法作出判断
     * 如果开发者自定义了纵向表头，则直接返回其自定义的内容
     *
     * @return data list of column ListView
     */
    private List<String> getColumnDataList() {
        if (columnDataList == null) {
            defaultColumn = true;
            columnDataList = new ArrayList<>();
            for (int i = 1; i <= getContentAdapter().getItemCount(); i++) {
                columnDataList.add(String.valueOf(i));
            }
        }
        return columnDataList;
    }

    /**
     * 设置纵向表头的内容
     *
     * @param columnDataList data list of column layout, must be a List<String>. if you don`t call
     *                       this method, the default column list will be used
     */
    public void setColumnDataList(List<String> columnDataList) {
        this.columnDataList = columnDataList;
    }

    /**
     * 设置content的初始position
     * <p>
     * 比如你想进入这个Activity的时候让第300条数据显示在屏幕上（前提是该数据存在）
     * 那么在这里传入299即可
     *
     * @param initPosition position
     */
    public void setInitPosition(int initPosition) {
        this.initPosition = initPosition;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 横向表头的分割线
     */
    public void setRowDivider(Drawable rowDivider) {
        this.rowDivider = rowDivider;
    }

    /**
     * 设置是否开启下拉刷新（默认关闭）
     *
     * @param bool pass true to enable pullToRefresh
     */
    public void setSwipeRefreshEnabled(boolean bool) {
        swipeRefreshEnable = bool;
    }

    /**
     * 设置横向表头的标题（！！必须调用！！）
     *
     * @param rowDataList data list of row layout, must be a List<String>
     */
    public void setRowDataList(List<String> rowDataList) {
        this.rowDataList = rowDataList;
    }

    /**
     * 在该方法中返回contentList的adapter
     *
     * @return content部分的adapter
     */
    protected abstract RecyclerView.Adapter getContentAdapter();

    /**
     * 在该方法中纵向表头返回的adapter
     *
     * @return content部分的adapter
     */
    protected abstract RecyclerView.Adapter getColumnAdapter();

    /**
     * constructor
     *
     * @param lv_content 内容的RecyclerView
     */
    public AbstractPanelListAdapter1(Context context, PanelListLayout pl_root, RecyclerView lv_content) {
        this.context = context;
        this.pl_root = pl_root;
        this.lv_content = lv_content;
        titleWidth = (int) context.getResources().getDimension(R.dimen.x240);
        titleHeight = (int) context.getResources().getDimension(R.dimen.y70);
    }

    /**
     * HorizontalScrollView的滑动监听（水平方向同步控制）
     */
    private class HorizontalScrollListener implements MyHorizontalScrollView.OnHorizontalScrollListener {
        @Override
        public void onHorizontalScrolled(MyHorizontalScrollView view, int l, int t, int oldl, int oldt) {
            if (view == mhsv_content) {
                mhsv_row.scrollTo(l, t);
            } else {
                mhsv_content.scrollTo(l, t);
            }
        }
    }

    /**
     * 两个RecyclerView的滑动监听（垂直方向同步控制）
     */
    private class VerticalScrollListener extends RecyclerView.OnScrollListener {
        int scrollState;

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            this.scrollState = newState;
            // 没有滚动或手指在屏幕上
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (scrollState == SCROLL_STATE_IDLE || scrollState == SCROLL_STATE_DRAGGING) {
                View subView = recyclerView.getChildAt(0);
                if (layoutManager instanceof LinearLayoutManager) {
                    if (subView != null && recyclerView == lv_content) {
                        int top = subView.getTop();
                        int position = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                        RecyclerView.LayoutManager layoutManager1 = lv_column.getLayoutManager();
                        ((LinearLayoutManager) layoutManager1).scrollToPositionWithOffset(position, top);//
                    } else if (subView != null && recyclerView == lv_column) {
                        int top = subView.getTop();
                        int position = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                        RecyclerView.LayoutManager layoutManager1 = lv_content.getLayoutManager();
                        ((LinearLayoutManager) layoutManager1).scrollToPositionWithOffset(position, top);
                    }
                } else {
                    throw new ClassCastException("RecyclerView.LayoutManager is not LinearLayoutManager");
                }
            }
            // 上拉加载更多
            if (newState == SCROLL_STATE_IDLE || newState == SCROLL_STATE_SETTLING) {
                //判断是当前layoutManager是否为LinearLayoutManager
                // 只有LinearLayoutManager才有查找第一个和最后一个可见view位置的方法
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    //当停止滚动时或者惯性滚动时，RecyclerView的最后一个显示的条目：getCount()-1
                    //注意是findLastVisibleItemPosition()而不是getLastVisiblePosition
                    if (linearLayoutManager.findLastVisibleItemPosition() >= recyclerView.getAdapter().getItemCount() - 1) {
                        footerViewAnima();
                    }
                }
            }
            // 上拉加载更多，判断footView显现
            if (scrollState == SCROLL_STATE_IDLE || scrollState == SCROLL_STATE_SETTLING) {
                if (layoutManager instanceof LinearLayoutManager) {
                    // 滚动到最后的item时候，footView 也一并滚动，并且显现
//                    if (((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() == recyclerView.getAdapter().getItemCount() - 1) {
//                        footerView.setVisibility(View.VISIBLE);
//                    }else {
//                        footerView.setVisibility(View.GONE);
//                    }
                } else {
                    throw new ClassCastException("RecyclerView.LayoutManager is not LinearLayoutManager");
                }
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            //判断滑动是否终止，以停止自动对齐，否则该方法会一直被调用，影响性能
            if (scrollState == SCROLL_STATE_IDLE) {
                return;
            }
            View subView = recyclerView.getChildAt(0);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            int position = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            if (subView != null && recyclerView == lv_content) {
                int top = subView.getTop();
                RecyclerView.LayoutManager layoutManager1 = lv_column.getLayoutManager();
                ((LinearLayoutManager) layoutManager1).scrollToPositionWithOffset(position, top);//
            } else if (subView != null && recyclerView == lv_column) {
                int top = subView.getTop();
                RecyclerView.LayoutManager layoutManager1 = lv_content.getLayoutManager();
                ((LinearLayoutManager) layoutManager1).scrollToPositionWithOffset(position, top);//
            }
        }
    }

    private void footerViewAnima() {
//        ObjectAnimator animator = ObjectAnimator.ofFloat(footerView, "translationY", -500);
//        animator.setDuration(200);
//        animator.setInterpolator(new DecelerateInterpolator());//设置动画插入器，减速
//        animator.start();
        if (mOnRefreshListener != null)
            mOnRefreshListener.onLoadingMore();
    }

    public void setOnRefreshListener(AbstractPanelListAdapter.OnRefreshListener listener) {
        this.mOnRefreshListener = listener;
    }

    /**
     * 定义下拉刷新和上拉加载的接口
     */
    public interface OnRefreshListener {
        /**
         * 当下拉刷新是触发此方法
         */
        void onPullDownRefresh();

        /**
         * 当加载更多的时候回调这个方法
         */
        void onLoadingMore();
    }

    /**
     * 当刷新完数据之后，调用次方法，把头文件隐藏，并且状态设置为初始状态
     *
     * @param isSuccess
     */
    public void onFinishRefresh(boolean isSuccess) {
//        if (isLoadingMore) {
//            footerView.setPadding(0, -footerViewHeight, 0, 0);
//            isLoadingMore = false;
//        } else {
//            headerView.setPadding(0, -pulldownHeight, 0, 0);
//            currState = PULL_DOWN_REFRESH;
//            iv_header_refresh.setVisibility(VISIBLE);
//            pb_header_refresh.setVisibility(GONE);
//            tv_status.setText("下拉刷新");
//            if (isSuccess) {
//                //设置更新时间
//                tv_time.setText(getSystemTime());
//            }
//        }
    }
}
