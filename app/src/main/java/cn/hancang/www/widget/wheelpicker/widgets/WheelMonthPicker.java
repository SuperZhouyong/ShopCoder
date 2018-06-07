package cn.hancang.www.widget.wheelpicker.widgets;

import android.content.Context;
import android.util.AttributeSet;


import cn.hancang.www.widget.wheelpicker.WheelPicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 月份选择器
 * <p>
 * Picker for Months
 *
 * @author AigeStudio 2016-07-12
 * @version 1
 */
public class WheelMonthPicker extends WheelPicker implements IWheelMonthPicker {
    private int mMonthStart = 1, mMonthEnd = 12;
    private int mSelectedMonth;

    public WheelMonthPicker(Context context) {
        this(context, null);
    }

    public WheelMonthPicker(Context context, AttributeSet attrs) {
        super(context, attrs);

        List<Integer> data = new ArrayList<>();
        for (int i = mMonthStart; i <= mMonthEnd; i++)
            data.add(i);
        super.setData(data);

        mSelectedMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        updateSelectedYear();
    }

    public void setmMonthEnd(int mMonthEnd) {
        this.mMonthEnd = mMonthEnd;
        updateSelectedYear();
    }

    private void updateSelectedYear() {
        setSelectedItemPosition(mSelectedMonth - 1);
    }

    @Override
    public void setData(List data) {
        throw new UnsupportedOperationException("You can not invoke setData in WheelMonthPicker");
    }

    @Override
    public int getSelectedMonth() {
        return mSelectedMonth;
    }

    @Override
    public void setSelectedMonth(int month) {
        mSelectedMonth = month;
        updateSelectedYear();
    }

    @Override
    public int getCurrentMonth() {
        return Integer.valueOf(String.valueOf(getData().get(getCurrentItemPosition())));
    }
}