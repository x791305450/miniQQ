package com.example.qq.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.qq.Bean.FriendZone;
import com.example.qq.R;
import com.example.qq.adapter.ZoneAdapter;

import java.util.ArrayList;

public class ZoneActivity extends Activity {
    private Context mContext=this;
    private ArrayList<FriendZone> friendZones;
    private RecyclerView zoneRecycler;
    private ZoneAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qq_zone);
        initData();
        initView();
    }

    private void initData(){
        if(friendZones==null){
            friendZones=new ArrayList<>();
        }
        FriendZone a1=new FriendZone();
        a1.setContentImg(R.drawable.a);
        a1.setUserImg(R.drawable.b);
        FriendZone a2=new FriendZone();
        a2.setContentImg(R.drawable.a);
        a2.setUserImg(R.drawable.b);
        friendZones.add(a1);
        friendZones.add(a2);
        friendZones.add(a1);
        friendZones.add(a2);
        friendZones.add(a1);
        friendZones.add(a2);
        friendZones.add(a1);
        friendZones.add(a2);
        friendZones.add(a1);
        friendZones.add(a2);
        adapter=new ZoneAdapter(mContext,friendZones);
    }
    public void initView(){
        zoneRecycler=findViewById(R.id.qq_zone);
        LinearLayoutManager layoutManager=new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        //GridLayoutManager gridLayoutManager=new GridLayoutManager(mContext,2,GridLayoutManager.VERTICAL,false);
        zoneRecycler.setLayoutManager(layoutManager);
        zoneRecycler.setAdapter(adapter);
    }
}
