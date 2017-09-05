package com.othershe.nicedialog;

import android.util.SparseArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {

    private SparseArray<View> views;
    private View convertView;

    private ViewHolder(View view) {
        convertView = view;
        views = new SparseArray<>();
    }

    public static ViewHolder create(View view) {
        return new ViewHolder(view);
    }

    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = convertView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return convertView;
    }

    public ViewHolder setText(int viewId, String text) {
        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }

    public ViewHolder setText(int viewId, int textId) {
        TextView textView = getView(viewId);
        textView.setText(textId);
        return this;
    }

    public ViewHolder setTextColor(int viewId, int colorId) {
        TextView textView = getView(viewId);
        textView.setTextColor(colorId);
        return this;
    }

    public ViewHolder setImageResource(int viewId, int imageRes) {
        ImageView imageView = getView(viewId);
        imageView.setImageResource(imageRes);
        return this;
    }

    public ViewHolder setChecked(int viewId, boolean isChecked) {
        CheckBox checkBox = getView(viewId);
        checkBox.setChecked(isChecked);
        return this;
    }

    public ViewHolder setOnClickListener(int viewId, View.OnClickListener clickListener) {
        View view = getView(viewId);
        view.setOnClickListener(clickListener);
        return this;
    }

    public ViewHolder setBackgroundResource(int viewId, int resId) {
        View view = getView(viewId);
        view.setBackgroundResource(resId);
        return this;
    }

    public ViewHolder setBackgroundColor(int viewId, int colorId) {
        View view = getView(viewId);
        view.setBackgroundColor(colorId);
        return this;
    }
}
