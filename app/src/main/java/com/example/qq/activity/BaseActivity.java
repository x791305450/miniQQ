package com.example.qq.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());//绑定布局
        initView();
        //checkNetWork();
    }

    public void checkNetWork(){Toast.makeText(this,"卖片+V：791305450",Toast.LENGTH_LONG).show();}

    abstract int setLayout();

    abstract void initView();
}
