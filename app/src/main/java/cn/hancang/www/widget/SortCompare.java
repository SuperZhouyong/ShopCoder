package cn.hancang.www.widget;

import java.util.Comparator;

/**
 * Created by Administrator on 2017/5/18 0018.
 */

public class SortCompare implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
//        LogUtils.logi("开始比较");
        return o1 > o2 ? o1 : o2;
    }
}
