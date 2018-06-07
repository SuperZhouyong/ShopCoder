/*
package com.intention.sqtwin.utils;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineDataSet;
import cn.hancang.www.R;
import BaseApplication;

*/
/**
 * Created by Administrator on 2017/4/17 0017.
 *//*


public class ChartUtils {
    */
/***
     * 线条样式
     *//*

    public static void lineStyle(LineDataSet set1, int color) {
        if (color == -1) {
            set1.setColor(BaseApplication.getAppContext().getResources().getColor(R.color.app_focus));
            set1.setCircleColor(BaseApplication.getAppContext().getResources().getColor(R.color.app_focus));
        } else {
            set1.setColor(color);
            set1.setCircleColor(color);
        }

        set1.setLineWidth(1f);
        set1.setCircleRadius(4.5f);//getResources().getDimensionPixelSize(R.dimen.x14) 外环
        set1.setCircleHoleRadius(3.5f);// 内环
        set1.setDrawValues(false);
    }

    */
/**
     * 虚线样式
     *
     * @param d11
     * @param
     *//*

    public static void dashline(LineDataSet d11, int color) {
        d11.setDrawHighlightIndicators(false);
        d11.enableDashedLine(10, 10, 0);
        d11.setCircleRadius(4.5f);
        d11.setCircleHoleRadius(3.5f);
//        d11.setDrawCircles(false);
//        d11.setDrawCircleHole(false);
        d11.setColor(color);
        d11.setCircleColor(color);//BaseApplication.getAppContext().getResources().getColor(color)
//        d11.setHighLightColor(getResources().getColor(R.color.app_bottom_colour));
        d11.setDrawValues(false);
    }

    public static void initChart(LineChart chart) {
        chart.setNoDataText("暂无数据"); // 空数据显示
        chart.setNoDataTextColor(BaseApplication.getAppContext().getResources().getColor(R.color.orange));
//        chart.setNoDataTextColor(BaseApplication.getAppContext().getResources().getColor(R.color.font_1));
        chart.setDoubleTapToZoomEnabled(false); // 双击放大
        chart.setDragEnabled(false); //拖拽
        chart.setScaleEnabled(false);// 双指放大
        chart.getAxisRight().setEnabled(false); // 禁用右边Y轴
        chart.getLegend().setEnabled(false);// 禁用标签
        chart.getDescription().setEnabled(false);// 禁用描述

    }

    public static int returnMax(float num) {
        int max = 0;
        if (num <= 10) {
            max = 10;
        } else if (num <= 20 && num > 10) {
            max = 20;
        } else if (num <= 30 && num > 20) {
            max = 30;
        } else if (num <= 40 && num > 30) {
            max = 40;
        } else if (num <= 50 && num > 40) {
            max = 50;
        } else if (num <= 60 && num > 50) {
            max = 60;
        } else if (num <= 70 && num > 60) {
            max = 70;
        } else if (num <= 80 && num > 70) {
            max = 80;
        } else if (num <= 90 && num > 80) {
            max = 90;
        } else {
            max = 100;
        }
        return max;
    }

}
*/
