package com.example.qq.Utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    public static ToastUtil inStance;

    public static ToastUtil getInstance(){
        if (inStance == null){
            synchronized (ToastUtil.class){
                if (inStance == null){
                    inStance = new ToastUtil();
                }
            }
        }
        return inStance;
    }
    public void showToast(Context context,String text){
        Toast.makeText(context,text,Toast.LENGTH_LONG).show();
    }
}
