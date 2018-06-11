package com.othershe.nicedialog;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;
import android.support.annotation.StyleRes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/28.
 */

public class DialogOptions implements Parcelable {

    //宽度dp
    private int width = 0;
    //高度dp
    private int height = 0;
    //该库的scale动画分为中心点在50%和100%两种情况
    //    如果遇到设置Scale动画时中心点偏移的情况，先检查xml布局中时候有横向纵向占满屏幕的view，
    //    如果有，那么请设置对应的以下属性
    //    如果没有那么请修改scale动画的中心点pivotX和pivotY，自行调整到合适的位置，、
    //    因为在某些情况中心点位置会不同，目前我只找到一些可能性，但不全面，因此自定义修改scale动画的中心点是目前的最好解决方案
    //是否横向占满
    private boolean isFullHorizontal = false;
    //是否纵向占满
    private boolean isFullVertical = false;

    //以下两个margin分别适用于横纵向不占满的情况
    //并且根据gravity来判定margin的方向，
    // 例如：当gravity为left和top的时候，
    // 此时的verticalMargin则代表距离left的Margin
    // 此时的horizontalMargin就代表距离top的Margin
    // 取值范围为0-1，代表相对于屏幕的百分比（屏幕宽高*margin取值范围）
    //上下边距
    private float verticalMargin = 0f;
    //左右边距
    private float horizontalMargin = 0f;

    //以下两个margin分别用于横纵向占满的情况
    //垂直方向上顶部和底部的margin
    private int fullVerticalMargin = 0;

    //水平方向上左右两边的margin
    private int fullHorizontalMargin = 0;
    //灰度深浅
    private float dimAmount = 0.3f;
    //dialog的位置（默认居中）
    private DialogGravity gravity = DialogGravity.CENTER_CENTER;
    //是否点击外部取消（包含返回按钮）
    private boolean outCancel = true;
    //是否点击屏幕区域取消（不包含返回按钮）
    private boolean touchCancel = true;
    //设置是否需要触发显示监听（可用于屏幕旋转时dialog被动取消时）
    private boolean enableDialogShowListener = true;
    //设置是否需要触发关闭监听（可用于屏幕旋转时dialog被动取消时）
    private boolean enableDialogDismissListener = true;

    //显示与消失的监听
    private Map<String, DialogInterface> showDismissMap;
    //按钮监听
    private OnKeyListener onKeyListener;
    //事件监听
    private ViewConvertListener convertListener;

    //动画
    @StyleRes
    private int animStyle = 0;

    //布局
    @LayoutRes
    private int layoutId = R.layout.loading_layout;

    public int getWidth() {
        return width;
    }

    public DialogOptions setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public DialogOptions setHeight(int height) {
        this.height = height;
        return this;
    }

    public boolean isFullHorizontal() {
        return isFullHorizontal;
    }

    public DialogOptions setFullHorizontal(boolean fullHorizontal) {
        isFullHorizontal = fullHorizontal;
        return this;
    }

    public boolean isFullVertical() {
        return isFullVertical;
    }

    public DialogOptions setFullVertical(boolean fullVertical) {
        isFullVertical = fullVertical;
        return this;
    }

    public float getVerticalMargin() {
        return verticalMargin;
    }

    public DialogOptions setVerticalMargin(float verticalMargin) {
        this.verticalMargin = verticalMargin;
        return this;
    }

    public float getHorizontalMargin() {
        return horizontalMargin;
    }

    public DialogOptions setHorizontalMargin(float horizontalMargin) {
        this.horizontalMargin = horizontalMargin;
        return this;
    }

    public int getFullVerticalMargin() {
        return fullVerticalMargin;
    }

    public DialogOptions setFullVerticalMargin(int fullVerticalMargin) {
        this.fullVerticalMargin = fullVerticalMargin;
        return this;
    }

    public int getFullHorizontalMargin() {
        return fullHorizontalMargin;
    }

    public DialogOptions setFullHorizontalMargin(int fullHorizontalMargin) {
        this.fullHorizontalMargin = fullHorizontalMargin;
        return this;
    }

    public float getDimAmount() {
        return dimAmount;
    }

    public DialogOptions setDimAmount(float dimAmount) {
        this.dimAmount = dimAmount;
        return this;
    }

    public DialogGravity getGravity() {
        return gravity;
    }

    public DialogOptions setGravity(DialogGravity gravity) {
        this.gravity = gravity;
        return this;
    }

    public boolean isOutCancel() {
        return outCancel;
    }

    public DialogOptions setOutCancel(boolean outCancel) {
        this.outCancel = outCancel;
        return this;
    }

    public boolean isTouchCancel() {
        return touchCancel;
    }

    public DialogOptions setTouchCancel(boolean touchCancel) {
        this.touchCancel = touchCancel;
        return this;
    }

    public boolean isEnableDialogShowListener() {
        return enableDialogShowListener;
    }

    public DialogOptions setEnableDialogShowListener(boolean enableDialogShowListener) {
        this.enableDialogShowListener = enableDialogShowListener;
        return this;
    }

    public boolean isEnableDialogDismissListener() {
        return enableDialogDismissListener;
    }

    public DialogOptions setEnableDialogDismissListener(boolean enableDialogDismissListener) {
        this.enableDialogDismissListener = enableDialogDismissListener;
        return this;
    }

    public Map<String,DialogInterface> getShowDismissMap() {
        return showDismissMap;
    }


    public DialogOptions addShowDisMissListener(String key, DialogInterface dialogInterface) {
        if (showDismissMap == null) {
            showDismissMap = new HashMap<>();
        }
        this.showDismissMap.put(key,dialogInterface);
        return this;
    }

    public int getAnimStyle() {
        return animStyle;
    }

    public DialogOptions setAnimStyle(int animStyle) {
        this.animStyle = animStyle;
        return this;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public DialogOptions setLayoutId(int layoutId) {
        this.layoutId = layoutId;
        return this;
    }

    public OnKeyListener getOnKeyListener() {
        return onKeyListener;
    }

    public DialogOptions setOnKeyListener(OnKeyListener onKeyListener) {
        this.onKeyListener = onKeyListener;
        return this;
    }

    public ViewConvertListener getConvertListener() {
        return convertListener;
    }

    public DialogOptions setConvertListener(ViewConvertListener convertListener) {
        this.convertListener = convertListener;
        return this;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeByte(this.isFullHorizontal ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isFullVertical ? (byte) 1 : (byte) 0);
        dest.writeFloat(this.verticalMargin);
        dest.writeFloat(this.horizontalMargin);
        dest.writeInt(this.fullVerticalMargin);
        dest.writeInt(this.fullHorizontalMargin);
        dest.writeFloat(this.dimAmount);
        dest.writeInt(this.gravity == null ? -1 : this.gravity.ordinal());
        dest.writeByte(this.outCancel ? (byte) 1 : (byte) 0);
        dest.writeByte(this.touchCancel ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableDialogShowListener ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableDialogDismissListener ? (byte) 1 : (byte) 0);
        dest.writeInt(this.showDismissMap.size());
        for (Map.Entry<String, DialogInterface> entry : this.showDismissMap.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeParcelable(entry.getValue(), flags);
        }
        dest.writeParcelable(this.onKeyListener, flags);
        dest.writeParcelable(this.convertListener, flags);
        dest.writeInt(this.animStyle);
        dest.writeInt(this.layoutId);
    }

    public DialogOptions() {
    }

    protected DialogOptions(Parcel in) {
        this.width = in.readInt();
        this.height = in.readInt();
        this.isFullHorizontal = in.readByte() != 0;
        this.isFullVertical = in.readByte() != 0;
        this.verticalMargin = in.readFloat();
        this.horizontalMargin = in.readFloat();
        this.fullVerticalMargin = in.readInt();
        this.fullHorizontalMargin = in.readInt();
        this.dimAmount = in.readFloat();
        int tmpGravity = in.readInt();
        this.gravity = tmpGravity == -1 ? null : DialogGravity.values()[tmpGravity];
        this.outCancel = in.readByte() != 0;
        this.touchCancel = in.readByte() != 0;
        this.enableDialogShowListener = in.readByte() != 0;
        this.enableDialogDismissListener = in.readByte() != 0;
        int showDismissMapSize = in.readInt();
        this.showDismissMap = new HashMap<String, DialogInterface>(showDismissMapSize);
        for (int i = 0; i < showDismissMapSize; i++) {
            String key = in.readString();
            DialogInterface value = in.readParcelable(DialogInterface.class.getClassLoader());
            this.showDismissMap.put(key, value);
        }
        this.onKeyListener = in.readParcelable(OnKeyListener.class.getClassLoader());
        this.convertListener = in.readParcelable(ViewConvertListener.class.getClassLoader());
        this.animStyle = in.readInt();
        this.layoutId = in.readInt();
    }

    public static final Creator<DialogOptions> CREATOR = new Creator<DialogOptions>() {
        @Override
        public DialogOptions createFromParcel(Parcel source) {
            return new DialogOptions(source);
        }

        @Override
        public DialogOptions[] newArray(int size) {
            return new DialogOptions[size];
        }
    };
}
