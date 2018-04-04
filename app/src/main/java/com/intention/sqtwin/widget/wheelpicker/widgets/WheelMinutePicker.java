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

public class WheelMinutePicker extends WheelPicker implements IWheelMinutePicker {
    private int mSelectedMinute;

    public WheelMinutePicker(Context context) {
        super(context);
    }

    public WheelMinutePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        List<String> data = new ArrayList<>();
        for (int i = 0; i <= 59; i++) {
            data.add(i <= 9 ? "0" + i : i + "");
        }
        super.setData(data);
        mSelectedMinute = Calendar.getInstance().get(Calendar.MINUTE);
        UpdateCurrentMinute();
    }

    private void UpdateCurrentMinute() {
        setSelectedItemPosition(mSelectedMinute);
    }

    @Override
    public void setData(List data) {
        throw new UnsupportedOperationException("You can not invoke setData in WheelMonthPicker");
    }


    @Override
    public int getSelectedMinute() {
        return mSelectedMinute;
    }

    @Override
    public void setSelectedMinute(int month) {
        mSelectedMinute = month;
        UpdateCurrentMinute();
    }

    @Override
    public String getCurrentMinute() {
        return String.valueOf(getData().get(getCurrentItemPosition()));
    }
}
