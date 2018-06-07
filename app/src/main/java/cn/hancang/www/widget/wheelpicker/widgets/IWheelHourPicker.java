package cn.hancang.www.widget.wheelpicker.widgets;

/**
 * 月份选择器方法接口
 * <p>
 * Interface of WheelMonthPicker
 *
 * @author AigeStudio 2016-07-12
 * @version 1
 */

public interface IWheelHourPicker {
    /**
     * 获取月份选择器初始化时选择的月份
     *
     * @return 选择的月份
     */
    int getSelectedHour();

    /**
     * 设置月份选择器初始化时选择的月份
     *
     * @param month 选择的月份
     */
    void setSelectedHour(int month);

    /**
     * 获取当前选择的月份
     *
     * @return 当前选择的月份
     */
    String getCurrentHour();
}
