package com.example.qq.Utils;


import com.google.gson.Gson;

public class JsonUtil {
    public static JsonUtil inStance;

    public static JsonUtil getInstance(){
        if (inStance==null){
            synchronized (JsonUtil.class){
                if(inStance==null){
                    inStance=new JsonUtil();
                }
            }
        }
        return inStance;
    }

    public<T> String beanToJson(T t){
        String jsonStr="";
        if(t!=null){
            Gson gson=new Gson();
            jsonStr=gson.toJson(t);
        }
        return jsonStr;
    }
    public <T> T jsonToBean(String jsonStr,Class<T> tClass){
        T t =null;
        if (jsonStr !=null|| jsonStr !=""){
            Gson gson=new Gson();
            t=gson.fromJson(jsonStr,tClass);
        }
        return t;
    }
}
