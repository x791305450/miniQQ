package com.example.qq.activity;

import android.content.Context;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.qq.Bean.Friend;
import com.example.qq.Bean.Money;
import com.example.qq.R;
import com.example.qq.adapter.FriendAdapter;
import com.example.qq.adapter.MoneyAdapter;

import java.util.ArrayList;

public class QQmoneyActivtiy extends BaseActivity {
    private GridView gridView;
    private ArrayList<Money> monies=new ArrayList<>();
    private Context context=this;
    private MoneyAdapter adapter;

    @Override
    int setLayout() {
        return R.layout.activity_qq_money;
    }

    @Override
    void initView() {
        initData();
        gridView=findViewById(R.id.gridView);
        gridView.setAdapter(adapter);
    }

    private void initData(){
        Money money=new Money();
        money.setText("校园贷");
        money.setImg(R.drawable.a);
        monies.add(money);

    }
}
