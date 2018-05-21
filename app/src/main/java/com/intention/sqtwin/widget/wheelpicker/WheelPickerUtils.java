package com.intention.sqtwin.widget.wheelpicker;

import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.intention.sqtwin.ComInterface.ClickListener;
import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baserx.RxBus;
import com.intention.sqtwin.bean.AllRegion;
import com.intention.sqtwin.bean.BeanId;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/2/17 0017.
 * 滚轮选择器的辅助类
 */

public class WheelPickerUtils {


    private static boolean TAG = false;
    private static boolean YEARTAG = false;// 监听年滑轮的滚动
    private static boolean MONTHTAG = false;// 监听年滑轮的滚动
    private static boolean DAYTAG = false;// 监听年滑轮的滚动

    private static volatile PopupWindow instance = null;
    private static final String[] threeDate = {"", "", ""};
    private static final String[] twoDate = {"", ""};
    private static String text = "";

    /*
        PopupWindow单例 静态就是.class 为锁
     */
    public synchronized static PopupWindow getPopupWindowInstance(View view) {
//        synchronized (PopupWindow.class) {
        if (instance == null) {
            instance = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
//                new PopupWindow();
        }
//        }
        return instance;
    }
    /**
     * 只有单个选择器的PopupWindow
     */
    public static PopupWindow oneWheelPickerPop(View view,
                                                final TextView textView, final List list, boolean isCyclic) {

        final PopupWindow pop = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
//        final PopupWindow pop =getPopupWindowInstance(view);
        pop.setOutsideTouchable(true);

        pop.setFocusable(true);// 点击back退出pop
        pop.setBackgroundDrawable(new ColorDrawable(0x30ff0000));// 设置背景透明，点击back退出pop
        pop.showAtLocation(view, Gravity.BOTTOM, 0, -450);//在父控件下方出来
        final WheelPicker wheelPicker = (WheelPicker) view.findViewById(R.id.wheelPicker);
        Button cancel = (Button) view.findViewById(R.id.cancel);
        Button confirm = (Button) view.findViewById(R.id.confirm);
//        wheelPicker.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(WheelPicker picker, Object data, int position) {
//                String chooseitem = String.valueOf(data);
//                text = chooseitem;
//                TAG = true;
//            }
//        });

        if (list != null) {
            wheelPicker.setData(list);// 设置数据
        }
        wheelPicker.setCyclic(isCyclic);// 是否循环

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();

                // 判断滚轮是否在有过滑动，然后点击确定
//                if (TAG) {
//                    textView.setText(text);
//                    TAG = false;
//                    text = "";
//                } else {
//                    textView.setText((String) list.get(0));
//                }
                textView.setText((String) list.get(wheelPicker.getCurrentItemPosition()));

            }
        });
        return pop;
    }

    public static PopupWindow threeWheelPickerPop(View view,
                                                  final TextView textView, final List<AllRegion.DataBean> mList) {
        String text = textView.getText().toString();
        String[] split = null;
        if (!text.isEmpty()) {
            split = text.split("/");
        }
        if (split != null && split.length != 3) {
            split = null;
        }

        final PopupWindow pop = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        pop.setOutsideTouchable(true);
        pop.setFocusable(true);// 点击back退出pop
        pop.setBackgroundDrawable(new ColorDrawable(0x30ff0000));// 设置背景透明，点击back退出pop
        pop.showAtLocation(view, Gravity.BOTTOM, 0, -450);//在父控件下方出来

        final WheelPicker provincePicker = (WheelPicker) view.findViewById(R.id.provincePicker);//省
        final WheelPicker cityPicker = (WheelPicker) view.findViewById(R.id.cityPicker);//市
        final WheelPicker regionPicker = (WheelPicker) view.findViewById(R.id.regionPicker);//区
        Button cancel = (Button) view.findViewById(R.id.cancel);
        Button confirm = (Button) view.findViewById(R.id.confirm);

        final ArrayList<String> list1 = new ArrayList<>();
        final ArrayList<String> list2 = new ArrayList<>();
        final ArrayList<String> list3 = new ArrayList<>();
       /* final ArrayList<String> list4 = new ArrayList<>();
        final ArrayList<String> list5 = new ArrayList<>();*/
       /* for (int i = 0; i < 10; i++) {
//            list1.add("北京" + i);
            list2.add("海淀海淀海淀海淀海淀海淀海淀海淀海淀" + i);
            list3.add("东城" + i);

        }*/
        for (AllRegion.DataBean Ad : mList) {
            list1.add(Ad.getArea_name());
        }
        AllRegion.DataBean dataBean;
        AllRegion.DataBean.CityBean childBeanX;
        if (split != null) {
            dataBean = mList.get(list1.indexOf(split[0]));

        } else {
            dataBean = mList.get(0);

        }
        list2.clear();
        list3.clear();
        for (AllRegion.DataBean.CityBean child : dataBean.getCity()) {
            list2.add(child.getArea_name());
        }
        if (split != null) {
            childBeanX = dataBean.getCity().get(list2.indexOf(split[1]));
        } else {
            childBeanX = dataBean.getCity().get(0);
        }

//        List<AllRegion.DataBean.ChildBeanX.ChildBean> child = dataBean.getChild().get(0).getChild();
        for (AllRegion.DataBean.CityBean.AreaBean mChild : childBeanX.getArea()) {
            list3.add(mChild.getArea_name());
        }


        provincePicker.setData(list1);
        cityPicker.setData(list2);
        regionPicker.setData(list3);

        if (split != null) {
            provincePicker.setSelectedItemPosition(list1.indexOf(split[0]));
            cityPicker.setSelectedItemPosition(list2.indexOf(split[1]));
            regionPicker.setSelectedItemPosition(list3.indexOf(split[2]));

      /*      LogUtils.logd("split--L" + split.length + "------");
            LogUtils.logd("split--L" + list2.toString());
            LogUtils.logd("split--L" + split[0] + list1.indexOf(split[0]));
            LogUtils.logd("split--L" + split[1] + list2.indexOf(split[1]));
            LogUtils.logd("split--L" + split[2] + list3.indexOf(split[2]));*/
        }

        provincePicker.setOnWheelChangeListener(new WheelPicker.OnWheelChangeListener() {
            @Override
            public void onWheelScrolled(int offset) {

            }

            @Override
            public void onWheelSelected(int position) {
                AllRegion.DataBean dataBean = mList.get(position);
//                List<AllRegion.DataBean.ChildBeanX> child = dataBean.getChild();
//                ArrayList mlist2 = new ArrayList()
                list2.clear();
                list3.clear();
                for (AllRegion.DataBean.CityBean child : dataBean.getCity()) {
                    list2.add(child.getArea_name());
                }
//                List<AllRegion.DataBean.ChildBeanX.ChildBean> child = dataBean.getChild().get(0).getChild();
                for (AllRegion.DataBean.CityBean.AreaBean mChild : dataBean.getCity().get(0).getArea()) {
                    list3.add(mChild.getArea_name());
                }


                cityPicker.setData(list2);
                regionPicker.setData(list3);
                cityPicker.setSelectedItemPosition(0);
                regionPicker.setSelectedItemPosition(0);
              /*  if (position % 2 == 0) {

                }*/
                /* else {
                    cityPicker.setData(list2);
                    regionPicker.setData(list3);
                    cityPicker.setSelectedItemPosition(0);
                    regionPicker.setSelectedItemPosition(0);
                }*/
            }

            @Override
            public void onWheelScrollStateChanged(int state) {

            }
        });
        cityPicker.setOnWheelChangeListener(new WheelPicker.OnWheelChangeListener() {
            @Override
            public void onWheelScrolled(int offset) {

            }

            @Override
            public void onWheelSelected(int position) {
//                provincePicker.getCurrentItemPosition();
//                cityPicker.getCurrentItemPosition();
//                AllRegion.DataBean.ChildBeanX.ChildBean childBean = mList.get(provincePicker.getCurrentItemPosition()).getChild().get(cityPicker.getCurrentItemPosition()).getChild().get(position);
                list3.clear();
                for (AllRegion.DataBean.CityBean.AreaBean childBean : mList.get(provincePicker.getCurrentItemPosition()).getCity().get(cityPicker.getCurrentItemPosition()).getArea()) {
                    list3.add(childBean.getArea_name());
                }

                regionPicker.setData(list3);
                regionPicker.setSelectedItemPosition(0);

               /* if (position % 2 == 0) {
                    regionPicker.setData(list5);
                    regionPicker.setSelectedItemPosition(0);
                } else {
                    regionPicker.setData(list3);
                    regionPicker.setSelectedItemPosition(0);
                }*/
            }

            @Override
            public void onWheelScrollStateChanged(int state) {

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText(provincePicker.getData().get(provincePicker.getCurrentItemPosition()) + "/" +
                        cityPicker.getData().get(cityPicker.getCurrentItemPosition()) + "/" +
                        regionPicker.getData().get(regionPicker.getCurrentItemPosition()));
                Integer ProvinceId = mList.get(provincePicker.getCurrentItemPosition()).getArea_id();
                Integer CityID = mList.get(provincePicker.getCurrentItemPosition()).getCity().get(cityPicker.getCurrentItemPosition()).getArea_id();
                Integer RegionId = mList.get(provincePicker.getCurrentItemPosition()).getCity().get(cityPicker.getCurrentItemPosition()).getArea().get(regionPicker.getCurrentItemPosition()).getArea_id();
//                Log.i("position","省  ===  "+provincePicker.getCurrentItemPosition()+"市  ===  "+cityPicker.getCurrentItemPosition()+"区  ===  "+regionPicker.getCurrentItemPosition());
                //todo 需要传递给当前调用的类
                BeanId mBeanID = new BeanId();
                mBeanID.setProvinceId(ProvinceId);
                mBeanID.setCityId(CityID);
                mBeanID.setRegionID(RegionId);
                RxBus.getInstance().post(AppConstant.ConfirmOk, mBeanID);
                pop.dismiss();
            }
        });

        return pop;
    }

    /**
     * 将  “****年**月**日”  进行拆分
     */
    private static String[] splitData(String s) {
        String str = s.trim();
        String[] list = {"", "", ""};
        String year = str.substring(0, 4);
        String month = str.substring((str.indexOf("年") + 1), str.indexOf("月"));
        String day = str.substring(str.indexOf("月") + 1, str.indexOf("日"));
        list[0] = year;
        list[1] = month;
        list[2] = day;
        return list;
    }

    /**
     * 将  “****年**月”  进行拆分
     */
    public static String[] splitData1(String s) {
        if (!s.isEmpty()) {
            String str = s.trim();
            String[] list = {"", ""};
            String year = str.substring(0, 4);
            String month = str.substring((str.indexOf("年") + 1), str.length());
            list[0] = year;
            list[1] = month;
            return list;
        }
        return null;
    }


    /**
     * 两个窗口选择
     *
     * @param view
     */
    public static PopupWindow twoWheelPickerListener(View view, final List<String> list, final List<String> list1,
                                                     final TextView textView, final int tag, final ClickListener clickListener) {
        String str = textView.getText().toString();
        String str1 = "";
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            str1 = str.substring(0, 2);// 选考科目
            str2 = str.substring(2, str.length());// 等级
        }

        final PopupWindow pop = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        pop.setOutsideTouchable(true);
        pop.setFocusable(true);// 点击back退出pop
        pop.setBackgroundDrawable(new ColorDrawable(0x30ff0000));// 设置背景透明，点击back退出pop
        pop.showAtLocation(view, Gravity.BOTTOM, 0, -450);//在父控件下方出来
        final WheelPicker subjectPicker = (WheelPicker) view.findViewById(R.id.provincePicker);
        final WheelPicker levelPicker = (WheelPicker) view.findViewById(R.id.cityPicker);
        Button cancel = (Button) view.findViewById(R.id.cancel);
        Button confirm = (Button) view.findViewById(R.id.confirm);

        if (list != null) {
            subjectPicker.setData(list);// 设置数据
        }
        subjectPicker.setCyclic(false);// 是否循环

        if (list1 != null) {
            levelPicker.setData(list1);// 设置数据
        }
        levelPicker.setCyclic(false);// 是否循环
        // 回显
        if (!TextUtils.isEmpty(str)) {
            subjectPicker.setSelectedItemPosition(list.indexOf(str1));
            levelPicker.setSelectedItemPosition(list1.indexOf(str2));
        }


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
                textView.setText(list.get(subjectPicker.getCurrentItemPosition()) +
                        list1.get(levelPicker.getCurrentItemPosition()));
                if (clickListener != null)
                    clickListener.onPopClickListener(tag, list.get(subjectPicker.getCurrentItemPosition()), list1.get(levelPicker.getCurrentItemPosition()));
            }
        });
        return pop;
    }
}
