package com.rxy.hideheadlayout_master.base;

import android.support.v7.widget.RecyclerView;

import com.rxy.hideheadlayout_master.utils.L;

/**
 * Created by rxy on 15/7/3.
 * E－mail:rxywxsy@163.com
 */
public abstract class ControlScrollListener extends RecyclerView.OnScrollListener {

    private static final int HIDE_DISTANCE = 30;
    private int scrollDistance = 0;
    //判断toolbar是否显示
    private boolean isToVisible = true;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        L.e("onScrolled---------------->"+dy,true);
        //向下滚动
        if (scrollDistance > HIDE_DISTANCE && isToVisible) {
            onHide();
            isToVisible = false;
            scrollDistance = 0;
        }//向上滚动
        else if (scrollDistance < -HIDE_DISTANCE && !isToVisible) {
            onShow();
            isToVisible = true;
            scrollDistance = 0;
        }

        if (isToVisible && dy > 0 || !isToVisible && dy < 0) {
            scrollDistance += dy;
        }
    }

    public abstract void onHide();

    public abstract void onShow();
}
