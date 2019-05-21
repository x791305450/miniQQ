package com.example.qq.Utils.http;

import android.util.Log;

import com.example.qq.Utils.JsonUtil;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.util.concurrent.TimeUnit;

public class RequestManger {
    public static RequestManger inStance;
    public static OkHttpClient okHttpClient=new OkHttpClient();

    public RequestManger(){
        this.okHttpClient.setConnectTimeout(10L, TimeUnit.SECONDS);
        this.okHttpClient.setReadTimeout(10L,TimeUnit.SECONDS);
        this.okHttpClient.setWriteTimeout(10L,TimeUnit.SECONDS);
        this.okHttpClient.setCookieHandler(new CookieManager((CookieStore)null, CookiePolicy.ACCEPT_ORIGINAL_SERVER));
    }
    public static RequestManger getInstance(){
        if (inStance==null){
            synchronized (RequestManger.class){
                if(inStance==null){
                    inStance=new RequestManger();
                }
            }
        }
        return inStance;
    }
    public  void getSever(String url){
        Request.Builder builder=new Request.Builder();
        //builder.addHeader("token","1123");
        builder.url(url);
        Request request=builder.build();
        //自己创建子线程去执行
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.e("data", JsonUtil.getInstance().beanToJson(request));
            }

            @Override
            public void onResponse(Response response) throws IOException {

            }
        });
    }
}
