package com.contrarywind.listener;

import android.view.MotionEvent;

import com.contrarywind.view.WheelViewNoHour;


/**
 * 手势监听
 */
public final class LoopViewGestureListener extends android.view.GestureDetector.SimpleOnGestureListener {

    private final WheelViewNoHour wheelViewNoHour;


    public LoopViewGestureListener(WheelViewNoHour wheelViewNoHour) {
        this.wheelViewNoHour = wheelViewNoHour;
    }

    @Override
    public final boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        wheelViewNoHour.scrollBy(velocityY);
        return true;
    }
}
