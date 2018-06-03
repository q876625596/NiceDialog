package com.othershe.nicedialog;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/2/28.
 */

public abstract class DialogInterface implements Parcelable {

    abstract public void onDialogShow();

    abstract public void onDialogDismiss();

    public boolean isEnableDialogShowListener(){
        return true;
    }

    public boolean isEnableDialogDismissListener(){
        return true;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public DialogInterface() {
    }

    protected DialogInterface(Parcel in) {
    }

    public static final Creator<DialogInterface> CREATOR = new Creator<DialogInterface>() {
        @Override
        public DialogInterface createFromParcel(Parcel source) {
            return new DialogInterface(source) {
                @Override
                public void onDialogShow() {

                }

                @Override
                public void onDialogDismiss() {

                }
            };
        }

        @Override
        public DialogInterface[] newArray(int size) {
            return new DialogInterface[size];
        }
    };
}
