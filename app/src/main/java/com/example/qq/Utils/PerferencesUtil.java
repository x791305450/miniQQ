package com.example.qq.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PerferencesUtil {
    public static PerferencesUtil inStance;
    private  Context context;

    public PerferencesUtil(Context context){
        this.context=context;
    }

    public static PerferencesUtil getInstance(Context context){
        if (inStance == null){
            synchronized (PerferencesUtil.class){
                if (inStance == null){
                    inStance = new PerferencesUtil(context);
                }
            }
        }
        return inStance;
    }

    public SharedPreferences  getSharedPreferences(String name){
        return context.getSharedPreferences(name,Context.MODE_PRIVATE);
    }

    public void saveData(String key,String value){
        SharedPreferences.Editor editor=getSharedPreferences(key).edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String readData(String key){
        return getSharedPreferences(key).getString(key,null);
    }

    public<T> void saveData(String key,T vaule){
        saveData(key,JsonUtil.getInstance().beanToJson(vaule));
    }

    public<T> T getData(String key,Class<T> clazz){
        T t=null;
        t=JsonUtil.getInstance().jsonToBean(readData(key),clazz);
        return t;
    }
}
