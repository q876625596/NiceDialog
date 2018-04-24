package com.othershe.nicedialog;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class NiceDialog extends BaseNiceDialog {

    public static NiceDialog init() {
        return new NiceDialog();
    }

    @Override
    public void convertView(ViewHolder holder, BaseNiceDialog dialog) {
        if (getDialogOptions().getConvertListener() != null) {
            getDialogOptions().getConvertListener().convertView(holder, dialog);
        }
    }

    @Override
    public int getLayout() {
        return 0;
    }
}
