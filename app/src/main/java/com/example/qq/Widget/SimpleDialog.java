package com.example.qq.Widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

public class SimpleDialog {
    public static SimpleDialog inStance;
    private Context mContext;

    private View.OnClickListener listener;

    public SimpleDialog(Context context){
        this.mContext=context;
    }
    public static SimpleDialog getInstance(Context context){
        if (inStance == null){
            synchronized (SimpleDialog.class){
                if (inStance == null){
                    inStance = new SimpleDialog(context);
                }
            }
        }
        return inStance;
    }
    public void show(String title, String message, DialogInterface.OnCancelListener listener){
        AlertDialog.Builder builder =new AlertDialog.Builder(mContext);
        builder.setCancelable(false);
        builder.setTitle("换头像");    //设置弹窗标题
        builder.setMessage("你确定要更换头像么?");       //设置提示内容
        builder.setPositiveButton("确定",null);//设置确定
        builder.setNegativeButton("取消",null);//设置取消键
        builder.create().show();    //开始建造弹窗，并弹出来
    }
}

