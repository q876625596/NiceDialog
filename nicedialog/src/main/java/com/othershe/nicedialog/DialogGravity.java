package com.othershe.nicedialog;

import android.view.Gravity;

/**
 * Created by Administrator on 2018/2/28.
 */

public enum DialogGravity {
    LEFT_TOP(Gravity.START | Gravity.TOP),
    CENTER_TOP(Gravity.CENTER_HORIZONTAL | Gravity.TOP),
    RIGHT_TOP(Gravity.END | Gravity.TOP),
    LEFT_CENTER(Gravity.START | Gravity.CENTER_VERTICAL),
    CENTER_CENTER(Gravity.CENTER),
    RIGHT_CENTER(Gravity.END | Gravity.CENTER_VERTICAL),
    LEFT_BOTTOM(Gravity.START | Gravity.BOTTOM),
    CENTER_BOTTOM(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM),
    RIGHT_BOTTOM(Gravity.END | Gravity.BOTTOM);

    private int index;

    private DialogGravity(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
