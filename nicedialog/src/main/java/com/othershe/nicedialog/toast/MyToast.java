package com.othershe.nicedialog.toast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.othershe.nicedialog.R;

/**
 * Created by Administrator on 2016/9/9 0009.
 */
public class MyToast {
    private Toast mToast;

    private MyToast(Context context, CharSequence text, int duration) {
        View v = LayoutInflater.from(context).inflate(R.layout.eplay_toast, null);
        TextView textView = (TextView) v.findViewById(R.id.textView1);
        textView.setText(text);
        mToast = new Toast(context);
        mToast.setDuration(duration);
        mToast.setView(v);
    }

    private static MyToast makeText(Context context, CharSequence text, int duration) {
        return new MyToast(context, text, duration);
    }

    private void show() {
        if (mToast != null) {
            mToast.show();
        }
    }

    private void setGravity(int gravity, int xOffset, int yOffset) {
        if (mToast != null) {
            mToast.setGravity(gravity, xOffset, yOffset);
        }
    }

    public static void myToastShow(Context context, String message) {
        MyToast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void myToastShowLong(Context context, String message) {
        MyToast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
