package com.intention.sqtwin.baseadapterL.commonadcpter;

public interface MultiItemTypeSupport<T> {
    int getLayoutId(int itemType);

    int getItemViewType(int position, T t);
}