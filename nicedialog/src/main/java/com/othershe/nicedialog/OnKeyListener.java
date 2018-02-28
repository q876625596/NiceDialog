package com.othershe.nicedialog;

import android.content.*;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.KeyEvent;

/**
 * Created by Administrator on 2018/2/28.
 */

public abstract class OnKeyListener implements android.content.DialogInterface.OnKeyListener, Parcelable {


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public OnKeyListener() {
    }

    protected OnKeyListener(Parcel in) {
    }

    public static final Parcelable.Creator<OnKeyListener> CREATOR = new Parcelable.Creator<OnKeyListener>() {
        @Override
        public OnKeyListener createFromParcel(Parcel source) {
            return new OnKeyListener(source){
                @Override
                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                    return false;
                }
            };
        }

        @Override
        public OnKeyListener[] newArray(int size) {
            return new OnKeyListener[size];
        }
    };
}