package com.example.qq.activity;


import android.content.Context;
import android.content.Intent;

import com.example.qq.Bean.Friend;
import com.example.qq.R;
import com.example.qq.Utils.ToastUtil;

public class ChatFriendActivity extends BaseActivity {
    private Friend friend;
    public Context context;
    @Override
    int setLayout() {
        return R.layout.activity_chat;
    }

    @Override
    void initView() {
        getData();
    }

    private void getData(){
        Intent intent=getIntent();
        friend=(Friend) intent.getSerializableExtra("friend");
        if (friend==null){
            ToastUtil.getInstance().showToast(context,friend.getName());
        }
    }
}
