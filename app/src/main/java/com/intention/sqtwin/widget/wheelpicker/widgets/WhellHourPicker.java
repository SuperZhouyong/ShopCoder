package com.intention.sqtwin.widget.wheelpicker.widgets;

import android.content.Context;
import android.util.AttributeSet;


import com.intention.sqtwin.widget.wheelpicker.WheelPicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @data 2017/3/10 0010
 * @aurher Administrator
 */

public class WhellHourPicker extends WheelPicker implements IWheelHourPicker {
    private int mSelectedHour;

    public WhellHourPicker(Context context) {
        super(context);
    }

    public WhellHourPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        List<String> data = new ArrayList<>();
        for (int i = 1; i <= 24; i++) {
            data.add(i <= 9 ? "0" + i : i + "");
        }
        super.setData(data);
        mSelectedHour = Calendar.getInstance().get(Calendar.HOUR) - 2;
        UpdateCurrentHour();
    }

    private void UpdateCurrentHour() {
        setSelectedItemPosition(mSelectedHour - 1);
    }

    @Override
    public void setData(List data) {
        throw new UnsupportedOperationException("You can not invoke setData in WheelMonthPicker");
    }

    @Override
    public int getSelectedHour() {
        return mSelectedHour;
    }

    @Override
    public void setSelectedHour(int month) {
        mSelectedHour = month;
        UpdateCurrentHour();
    }

    @Override
    public String getCurrentHour() {
        return String.valueOf(getData().get(getCurrentItemPosition()));
    }

   /* @Override
    public int getSelectedHour() {
        return mSelectedMinute;
    }

    @Override
    public void setSelectedHour(int month) {
        mSelectedMinute = month;
        UpdateCurrentMinute();
    }

    @Override
    public int getCurrentHour() {
        return Integer.valueOf(String.valueOf(getData().get(getCurrentItemPosition())));
    }*/
}
