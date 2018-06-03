package com.othershe.nicedialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

public abstract class BaseNiceDialog extends DialogFragment {

    private AppCompatActivity mActivity;

    //保存数据的标签
    private static final String OPTIONS = "options";

    //dialog配置
    private DialogOptions dialogOptions = new DialogOptions();

    //事件监听
    public abstract void convertView(ViewHolder holder, BaseNiceDialog dialog);

    public abstract int getLayout();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置dialog样式
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.NiceDialog);

        //恢复保存的数据
        if (savedInstanceState != null) {
            dialogOptions = savedInstanceState.getParcelable(OPTIONS);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (AppCompatActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //加载布局
        if (getLayout() != 0) {
            dialogOptions.setLayoutId(getLayout());
        }
        View view = inflater.inflate(dialogOptions.getLayoutId(), container, false);
        convertView(ViewHolder.create(view), this);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        //初始化配置
        initParams();
    }

    @Override
    public void onStop() {
        if (dialogOptions.getDialogInterface() != null) {
            for (DialogInterface d :
                    dialogOptions.getDialogInterface()) {
                //判断是否需要调用关闭dialog的回调
                if (d.isEnableDialogDismissListener()) {
                    d.onDialogDismiss();
                }
            }
        }
        super.onStop();
    }


    public AppCompatActivity getmActivity() {
        return mActivity;
    }

    /**
     * 屏幕旋转等导致DialogFragment销毁后重建时保存数据
     *
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(OPTIONS, dialogOptions);
    }

    private void initParams() {
        Window window = getDialog().getWindow();
        if (window != null) {
            WindowManager.LayoutParams lp = window.getAttributes();
            //调节灰色背景透明度[0-1]，默认0.3f
            lp.dimAmount = dialogOptions.getDimAmount();
            //设置位置
            lp.gravity = dialogOptions.getGravity().getIndex();
            //根据dialog的位置来设置默认anim
            switch (dialogOptions.getGravity().getIndex()) {
                //左上(默认动画从左至右加速减速,verticalMargin和horizontalMargin生效)
                case Gravity.START | Gravity.TOP:
                    //左中(默认动画从左至右加速减速,horizontalMargin生效)
                case Gravity.START | Gravity.CENTER_VERTICAL:
                    //左下(默认动画从左至右加速减速,verticalMargin和horizontalMargin生效)
                case Gravity.START | Gravity.BOTTOM:
                    if (dialogOptions.getAnimStyle() == 0) {
                        dialogOptions.setAnimStyle(R.style.LeftTransAlphaADAnimation);
                    }
                    break;
                //右上(默认动画从右至左加速减速,verticalMargin和horizontalMargin生效)
                case Gravity.END | Gravity.TOP:
                    //右中(默认动画从右至左加速减速,horizontalMargin生效)
                case Gravity.END | Gravity.CENTER_VERTICAL:
                    //右下(默认动画从右至左加速减速,verticalMargin和horizontalMargin生效)
                case Gravity.END | Gravity.BOTTOM:
                    if (dialogOptions.getAnimStyle() == 0) {
                        dialogOptions.setAnimStyle(R.style.RightTransAlphaADAnimation);
                    }
                    break;
                //正中(默认动画渐入渐出)
                case Gravity.CENTER:
                    if (dialogOptions.getAnimStyle() == 0) {
                        dialogOptions.setAnimStyle(R.style.AlphaEnterExitAnimation);
                    }
                    break;
                //中上(默认动画从上至下加速减速,verticalMargin生效)
                case Gravity.CENTER_HORIZONTAL | Gravity.TOP:
                    if (dialogOptions.getAnimStyle() == 0) {
                        dialogOptions.setAnimStyle(R.style.TopTransAlphaADAnimation);
                    }
                    break;
                //中下(默认动画从下至上加速减速,verticalMargin生效)
                case Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM:
                    if (dialogOptions.getAnimStyle() == 0) {
                        dialogOptions.setAnimStyle(R.style.BottomTransAlphaADAnimation);
                    }
                    break;
                //默认动画渐入渐出
                default:
                    dialogOptions.setAnimStyle(dialogOptions.getAnimStyle() == 0
                            ? R.style.AlphaEnterExitAnimation : dialogOptions.getAnimStyle());
            }

            //设置dialog宽度
            if (dialogOptions.getWidth() == 0) {
                lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
            } else {
                lp.width = Utils.dp2px(getContext(), dialogOptions.getWidth());
            }

            //设置dialog高度
            if (dialogOptions.getHeight() == 0) {
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            } else {
                lp.height = Utils.dp2px(getContext(), dialogOptions.getHeight());
            }

            //当左右占满时，设置左右两边的平均边距
            if (dialogOptions.isFullHorizontal()) {
                lp.horizontalMargin = 0f;
                lp.width = Utils.getScreenWidth(getContext()) - 2 * Utils.dp2px(getContext(), dialogOptions.getFullHorizontalMargin());
            } else {
                //没有占满的时候，设置水平方向的相对边距
                lp.horizontalMargin = dialogOptions.getHorizontalMargin();
            }
            //当上下占满时，设置上下的平均边距
            if (dialogOptions.isFullVertical()) {
                lp.verticalMargin = 0f;
                lp.height = Utils.getScreenHeight(getContext()) - 2 * Utils.dp2px(getContext(), dialogOptions.getFullVerticalMargin());
            } else {
                //没有占满的时候，设置水平方向的相对边距
                lp.verticalMargin = dialogOptions.getVerticalMargin();
            }

            //设置dialog进入、退出的动画
            window.setWindowAnimations(dialogOptions.getAnimStyle());
            window.setAttributes(lp);
        }
        //设置是否点击外部不消失
        setCancelable(dialogOptions.isOutCancel());
        //设置是否点击屏幕区域不消失（点击返回键可消失）
        setTouchOutSideCancelable();
        setOnKeyListener();
    }

    /**
     * 重写按钮监听
     */
    private void setOnKeyListener() {
        if (getFragmentManager() == null) {
            return;
        }
        if (dialogOptions.getOnKeyListener() == null) {
            return;
        }
        //boolean b = getFragmentManager().executePendingTransactions();
        getDialog().setOnKeyListener(dialogOptions.getOnKeyListener());
    }

    public BaseNiceDialog show(FragmentManager manager) {
        super.show(manager, String.valueOf(System.currentTimeMillis()));
        for (DialogInterface d :
                dialogOptions.getDialogInterface()) {
            if (d.isEnableDialogShowListener()) {
                d.onDialogShow();
            }
        }
        return this;
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if (dialogOptions.getDialogInterface() == null) {
            return;
        }
        for (DialogInterface d :
                dialogOptions.getDialogInterface()) {
            if (d.isEnableDialogDismissListener()) {
                d.onDialogDismiss();
            }
        }
    }

    public void setTouchOutSideCancelable() {
        getDialog().setCanceledOnTouchOutside(dialogOptions.isTouchCancel());
    }

    public DialogOptions getDialogOptions() {
        return dialogOptions;
    }

    public BaseNiceDialog setDialogOptions(DialogOptions dialogOptions) {
        this.dialogOptions = dialogOptions;
        return this;
    }

}
