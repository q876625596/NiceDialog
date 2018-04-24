package com.othershe.test;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.othershe.nicedialog.BaseNiceDialog;
import com.othershe.nicedialog.DialogGravity;
import com.othershe.nicedialog.DialogInterface;
import com.othershe.nicedialog.DialogOptions;
import com.othershe.nicedialog.NiceDialog;
import com.othershe.nicedialog.OnKeyListener;
import com.othershe.nicedialog.ViewConvertListener;
import com.othershe.nicedialog.ViewHolder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialog0(View view) {
        /*new DialogOptions()
                .setLayoutId(R.layout.share_layout)
                .setWidth(50)
                .setHeight(50)
                */
        NiceDialog.init().setDialogOptions(new DialogOptions()//设置options
                .setLayoutId(R.layout.share_layout)//
                //.setGravity(DialogGravity.CENTER_BOTTOM)
             /*   .setWidth(80)
                .setHeight(100)*/
                //.setAnimStyle(R.style.ScaleOverShootEnterExitAnimationH50V100)
                //.setFullHorizontal(true)
                //.setFullVertical(true)
                //.setHorizontalMargin(0.5f)
                //.setVerticalMargin(0.5f)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    protected void convertView(ViewHolder holder, BaseNiceDialog dialog) {

                       /* holder.setOnClickListener(R.id.wechat, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "分享成功", Toast.LENGTH_SHORT).show();
                            }
                        });*/
                    }
                })
                .setDialogInterface(new DialogInterface() {
                    @Override
                    public void onDialogShow() {
                        Log.e("ly", "show");
                    }

                    @Override
                    public void onDialogDismiss() {
                        Log.e("ly", "dismiss");
                    }
                })
                .setOnKeyListener(new OnKeyListener() {
                    @Override
                    public boolean onKey(android.content.DialogInterface dialog, int keyCode, KeyEvent event) {
                        /*if (keyCode == KeyEvent.KEYCODE_BACK) {
                            Toast.makeText(MainActivity.this, "back", Toast.LENGTH_SHORT).show();
                            return true;
                        }*/
                        return false;
                    }
                }))
                .show(getSupportFragmentManager());
    }

    public void showDialog1(View view) {
        NiceDialog.init().setDialogOptions(new DialogOptions()//设置options
                .setLayoutId(R.layout.share_layout)//
                .setGravity(DialogGravity.CENTER_CENTER)
                .setWidth(80)
                .setFullVertical(true)
                .setFullHorizontal(true)
                .setFullHorizontalMargin(10)
                .setFullVerticalMargin(30)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    protected void convertView(ViewHolder holder, BaseNiceDialog dialog) {
                       /* holder.setOnClickListener(R.id.wechat, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "分享成功", Toast.LENGTH_SHORT).show();
                            }
                        });*/
                    }
                })
                .setDialogInterface(new DialogInterface() {
                    @Override
                    public void onDialogShow() {
                        Log.e("ly", "show");
                    }

                    @Override
                    public void onDialogDismiss() {
                        Log.e("ly", "dismiss");
                    }
                })
                .setOnKeyListener(new OnKeyListener() {
                    @Override
                    public boolean onKey(android.content.DialogInterface dialog, int keyCode, KeyEvent event) {
                        if (keyCode == KeyEvent.KEYCODE_BACK) {
                            Toast.makeText(MainActivity.this, "back", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        return false;
                    }
                }))
                .show(getSupportFragmentManager());
    }
/*
    public void showDialog2(View view) {
        NiceDialog.init()
                .setLayoutId(R.layout.commit_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                        final EditText editText = holder.getView(R.id.edit_input);
                        editText.post(new Runnable() {
                            @Override
                            public void run() {
                                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                imm.showSoftInput(editText, 0);
                            }
                        });
                    }
                })
                .setShowBottom(true)
                .show(getSupportFragmentManager());
    }

    public void showDialog3(View view) {
        NiceDialog.init()
                .setLayoutId(R.layout.ad_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                        holder.setOnClickListener(R.id.close, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                    }
                })
                .setWidth(210)
                .setOutCancel(false)
                .setAnimStyle(R.style.EnterExitAnimation)
                .show(getSupportFragmentManager());
    }


    public void showDialog4(View view) {
        NiceDialog.init()
                .setLayoutId(R.layout.loading_layout)
                .setWidth(100)
                .setHeight(100)
                .setAnimStyle(R.style.AlphaEnterExitAnimation)
                .setDimAmount(0.2f)
                .show(getSupportFragmentManager());
    }

    public void showDialog5(View view) {
        ConfirmDialog.newInstance("1")
                .setMargin(60)
                .setOutCancel(false)
                .show(getSupportFragmentManager());
    }

    public void showDialog6(View view) {
        ConfirmDialog.newInstance("2")
                .setMargin(60)
                .setOutCancel(false)
                .show(getSupportFragmentManager());
    }

    public static class ConfirmDialog extends BaseNiceDialog {
        private String type;

        public static ConfirmDialog newInstance(String type) {
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            ConfirmDialog dialog = new ConfirmDialog();
            dialog.setArguments(bundle);
            return dialog;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle bundle = getArguments();
            if (bundle == null) {
                return;
            }
            type = bundle.getString("type");
        }

        @Override
        public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
            if ("1".equals(type)) {
                holder.setText(R.id.title, "提示");
                holder.setText(R.id.message, "您已支付成功！");
            } else if ("2".equals(type)) {
                holder.setText(R.id.title, "警告");
                holder.setText(R.id.message, "您的账号已被冻结！");
            }
            holder.setOnClickListener(R.id.cancel, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            holder.setOnClickListener(R.id.ok, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }
    }
    */
}
