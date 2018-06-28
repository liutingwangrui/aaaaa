package com.contrarywind.timer;

import com.contrarywind.view.WheelViewNoHour;

import java.util.TimerTask;

/**
 * 平滑滚动的实现
 *
 * @author 小嵩
 */
public final class SmoothScrollTimerTask extends TimerTask {

    private int realTotalOffset;
    private int realOffset;
    private int offset;
    private final WheelViewNoHour wheelViewNoHour;

    public SmoothScrollTimerTask(WheelViewNoHour wheelViewNoHour, int offset) {
        this.wheelViewNoHour = wheelViewNoHour;
        this.offset = offset;
        realTotalOffset = Integer.MAX_VALUE;
        realOffset = 0;
    }

    @Override
    public final void run() {
        if (realTotalOffset == Integer.MAX_VALUE) {
            realTotalOffset = offset;
        }
        //把要滚动的范围细分成10小份，按10小份单位来重绘
        realOffset = (int) ((float) realTotalOffset * 0.1F);

        if (realOffset == 0) {
            if (realTotalOffset < 0) {
                realOffset = -1;
            } else {
                realOffset = 1;
            }
        }

        if (Math.abs(realTotalOffset) <= 1) {
            wheelViewNoHour.cancelFuture();
            wheelViewNoHour.getHandler().sendEmptyMessage(MessageHandler.WHAT_ITEM_SELECTED);
        } else {
            wheelViewNoHour.setTotalScrollY(wheelViewNoHour.getTotalScrollY() + realOffset);

            //这里如果不是循环模式，则点击空白位置需要回滚，不然就会出现选到－1 item的 情况
            if (!wheelViewNoHour.isLoop()) {
                float itemHeight = wheelViewNoHour.getItemHeight();
                float top = (float) (-wheelViewNoHour.getInitPosition()) * itemHeight;
                float bottom = (float) (wheelViewNoHour.getItemsCount() - 1 - wheelViewNoHour.getInitPosition()) * itemHeight;
                if (wheelViewNoHour.getTotalScrollY() <= top || wheelViewNoHour.getTotalScrollY() >= bottom) {
                    wheelViewNoHour.setTotalScrollY(wheelViewNoHour.getTotalScrollY() - realOffset);
                    wheelViewNoHour.cancelFuture();
                    wheelViewNoHour.getHandler().sendEmptyMessage(MessageHandler.WHAT_ITEM_SELECTED);
                    return;
                }
            }
            wheelViewNoHour.getHandler().sendEmptyMessage(MessageHandler.WHAT_INVALIDATE_LOOP_VIEW);
            realTotalOffset = realTotalOffset - realOffset;
        }
    }
}
