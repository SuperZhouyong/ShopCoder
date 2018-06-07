package cn.hancang.www.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.hancang.www.R;

/**
 * Description: 保佑无bug
 * Data：2018/5/4-上午1:11
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class ShareDialog extends Dialog{
    private Button yes;//确定按钮
    private Button no;//取消按钮
    private TextView titleTv;//消息标题文本
    private TextView messageTv;//消息提示文本
    private String titleStr;//从外界设置的title文本

    public String getMessageStr() {
        return messageStr;
    }

    public void setMessageStr(String messageStr) {
        this.messageStr = messageStr;
    }

    private String messageStr;//从外界设置的消息文本
    private String yesStr, noStr;
    private NormalDialog.onNoOnclickListener noOnclickListener;//取消按钮被点击了的监听器
    private NormalDialog.onYesOnclickListener yesOnclickListener;//确定按钮被点击了的监听器
    private LinearLayout llNo;// 取消按钮布局
    private int visible;//取消按钮是否可见
    private WindowManager.LayoutParams params;
    private int idlayout; // 自定义布局
    private boolean b; // tag 判断
    private int yesTextColor = -1;
    private int noTextColor = -1;
    private int yesTextStyle = -1;
    private boolean isBold;


    public void setCanCancleOutSide(boolean canCancleOutSide) {
        this.canCancleOutSide = canCancleOutSide;
    }

    private boolean canCancleOutSide = true;
    //确定文本和取消文本的显示内容


    /**
     * 设置取消按钮的显示内容和监听
     *
     * @param str
     * @param onNoOnclickListener
     */
    public void setNoOnclickListener(String str, NormalDialog.onNoOnclickListener onNoOnclickListener) {
        if (str != null) {
            noStr = str;
        }
        this.noOnclickListener = onNoOnclickListener;
    }

    /**
     * 设置确定按钮的显示内容和监听
     *
     * @param str
     * @param onYesOnclickListener
     */
    public void setYesOnclickListener(String str, NormalDialog.onYesOnclickListener onYesOnclickListener) {
        if (str != null) {
            yesStr = str;
        }
        this.yesOnclickListener = onYesOnclickListener;
    }

    public ShareDialog(Context context, int Idlayout, boolean b) {
        super(context, R.style.MyDialog);
        idlayout = Idlayout;
        this.b = b;// true  没有取消按钮，false   有取消按钮
    }

    public ShareDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(idlayout);
        //按空白处不能取消动画
        setCanceledOnTouchOutside(canCancleOutSide);

        //初始化界面控件
        initView();
        //初始化界面数据
        initData();
        //初始化界面控件的事件
        initEvent();

    }

    /**
     * 初始化界面的确定和取消监听器
     */
    private void initEvent() {
        //设置确定按钮被点击后，向外界提供监听
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yesOnclickListener != null) {
                    yesOnclickListener.onYesClick();
                }
            }
        });
        //设置取消按钮被点击后，向外界提供监听
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noOnclickListener != null) {
                    noOnclickListener.onNoClick();
                }
            }
        });
    }

    /**
     * 初始化界面控件的显示数据
     */
    private void initData() {
        //如果用户自定了title和message
        if (titleStr != null) {
            titleTv.setText(titleStr);
        }
        if (messageStr != null) {
            messageTv.setText(messageStr);
        }
        //如果设置按钮的文字
        if (yesStr != null) {
            yes.setText(yesStr);
        }
        if (noStr != null) {
            no.setText(noStr);
        }
        //如果设置按钮的颜色
        if (yesTextColor !=-1){
            yes.setTextColor(yesTextColor);
        }
        if (noTextColor !=-1){
            no.setTextColor(noTextColor);
        }
        if (yesTextStyle !=-1){
            yes.setTypeface(Typeface.defaultFromStyle(yesTextStyle));
        }
    }

    /**
     * 初始化界面控件
     */
    private void initView() {
        if (b) {
            yes = (Button) findViewById(R.id.yes);
            messageTv = (TextView) findViewById(R.id.message);
            no = (Button) findViewById(R.id.no);
            llNo = (LinearLayout) findViewById(R.id.ll_no);
            llNo.setVisibility(View.GONE);
        } else {
            yes = (Button) findViewById(R.id.yes);
            no = (Button) findViewById(R.id.no);
//            titleTv = (TextView) findViewById(R.id.title);
            messageTv = (TextView) findViewById(R.id.message);
//        messageTv.setTextColor(messageColor);
            llNo = (LinearLayout) findViewById(R.id.ll_no);
            llNo.setVisibility(visible);
        }
//        if (isBold)
//            yes.settext

    }

    /**
     * 从外界Activity为Dialog设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        titleStr = title;
    }

    /**
     * 从外界Activity为Dialog设置no按钮是否可见
     *
     * @param
     */
    public void setllNoVisible(int visible) {
        this.visible = visible;
    }

    /**
     * 设置确定按钮的颜色
     */
    public void setYesTextColor(int color){
        yesTextColor = color;
    }
    /**
     * 设置取消按钮的颜色
     */
    public void setNoTextColor(int color){
        noTextColor = color;
    }

    /*
    * 设置确定String
    * */
    public void setYesTextString(String yesString){

    }
    /**
     * 设置确定按钮的字体样式
     * @param style  Typeface
     */
    public void setYesTextStyle(int style){
        yesTextStyle = style;
    }
    /**
     * 从外界Activity为Dialog设置dialog的message
     *
     * @param message
     */
    public void setMessage(String message) {
        messageStr = message;
    }

    public void setYesTextBold(boolean isBold) {


        this.isBold = isBold;
    }

    /**
     * 设置确定按钮和取消被点击的接口
     */
    public interface onYesOnclickListener {
        public void onYesClick();
    }

    public interface onNoOnclickListener {
        public void onNoClick();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            dismiss();
        }
        return super.onKeyDown(keyCode, event);

    }
}
