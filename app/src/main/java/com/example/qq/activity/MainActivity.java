package com.example.qq.activity;

import android.util.Log;

import com.example.qq.R;

public class MainActivity extends BaseActivity {


    @Override
    int setLayout() {
      return  R.layout.activtiy_qq_main;
    }

    @Override
    void initView() {

    }
    public static final String M_TAG="ActivityTest";

    protected  void onStart(){
        super.onStart();
        Log.i(M_TAG,"MainActivity onStart()invoked!");
    }

    protected  void onResume(){
        super.onResume();
        Log.i(M_TAG,"MainActivity onResume()invoked!");
    }

    protected  void onRestart(){
        super.onRestart();
        Log.i(M_TAG,"MainActivity onRestart()invoked!");
    }

    protected  void onPause(){
        super.onPause();
        Log.i(M_TAG,"MainActivity onPause()invoked!");
    }

    protected  void onStop(){
        super.onStop();
        Log.i(M_TAG,"MainActivity onStop()invoked!");
    }

    protected  void onDestroy(){
        super.onDestroy();
        Log.i(M_TAG,"MainActivity onDestroy()invoked!");
    }
}
