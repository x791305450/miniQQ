package com.example.qq.activity;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.qq.Fragment.FragmentDongtai;
import com.example.qq.Fragment.FragmentLianxiren;
import com.example.qq.Fragment.FragmentMessage;
import com.example.qq.Fragment.FramentKandian;
import com.example.qq.R;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext=this;
    private LinearLayout part1,part2,part3,part4;
    private TextView texts1,texts2,texts3,texts4;
    private TextView titles;
    private FragmentMessage fragmentMessage;
    private FragmentLianxiren fragmentLianxiren;
    private FramentKandian framentKandian;
    private FragmentDongtai fragmentDongtai;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    public void initView(){
        part1=findViewById(R.id.part1);
        part2=findViewById(R.id.part2);
        part3=findViewById(R.id.part3);
        part4=findViewById(R.id.part4);

        texts1=findViewById(R.id.texts1);
        texts2=findViewById(R.id.texts2);
        texts3=findViewById(R.id.texts3);
        texts4=findViewById(R.id.texts4);

        titles=findViewById(R.id.titles);

        part1.setOnClickListener(this);
        part2.setOnClickListener(this);
        part3.setOnClickListener(this);
        part4.setOnClickListener(this);
    }

    public void changeToBlack(){
        texts1.setTextColor(getResources().getColor(R.color.colorBlack));
        texts2.setTextColor(getResources().getColor(R.color.colorBlack));
        texts3.setTextColor(getResources().getColor(R.color.colorBlack));
        texts4.setTextColor(getResources().getColor(R.color.colorBlack));
    }

    private void changeToRed(int flag){
        switch (flag){
            case 1:texts1.setTextColor(getResources().getColor(R.color.colorRed));break;
            case 2:texts2.setTextColor(getResources().getColor(R.color.colorRed));break;
            case 3:texts3.setTextColor(getResources().getColor(R.color.colorRed));break;
            case 4:texts4.setTextColor(getResources().getColor(R.color.colorRed));break;
        }
    }

    @Override
    public void onClick(View v) {
        transaction=getSupportFragmentManager().beginTransaction();
        changeToBlack();
        hidAllFragment();
        switch (v.getId()){
            case R.id.part1:changeToRed(1);
                            titles.setText("消息");
                            if (fragmentMessage==null){
                                fragmentMessage=new FragmentMessage();
                                transaction.add(R.id.fragment_contant,fragmentMessage);
                            }else {
                                transaction.show(fragmentMessage);
                            }
                            break;
            case R.id.part2:changeToRed(2);
                            titles.setText("联系人");
                            if (fragmentLianxiren==null){
                                fragmentLianxiren=new FragmentLianxiren();
                                transaction.add(R.id.fragment_contant,fragmentLianxiren);
                            }else {
                                transaction.show(fragmentLianxiren);
                            }
                            break;
            case R.id.part3:changeToRed(3);
                            titles.setText("看点");
                            if (framentKandian==null){
                                framentKandian=new FramentKandian();
                                transaction.add(R.id.fragment_contant,framentKandian);
                            }else {
                                transaction.show(framentKandian);
                            }
                            break;
            case R.id.part4:changeToRed(4);
                            titles.setText("动态");
                            if (fragmentDongtai==null){
                                fragmentDongtai=new FragmentDongtai();
                                transaction.add(R.id.fragment_contant,fragmentDongtai);
                            }else {
                                transaction.show(fragmentDongtai);
                            }
                            break;
        }
        transaction.commit();
    }

    public void hidAllFragment(){
        if (fragmentMessage!=null){
            transaction.hide(fragmentMessage);
        }
        if (fragmentLianxiren!=null){
            transaction.hide(fragmentLianxiren);
        }
        if (framentKandian!=null){
            transaction.hide(framentKandian);
        }
        if (fragmentDongtai!=null){
            transaction.hide(fragmentDongtai);
        }
    }
}
