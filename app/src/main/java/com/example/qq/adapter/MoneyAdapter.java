package com.example.qq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.qq.Bean.Money;
import com.example.qq.R;

import java.util.ArrayList;

public class MoneyAdapter extends BaseAdapter {
    private ArrayList<Money> monies;
    private Context mContext;
    private ViewHolder vHolder;
    public MoneyAdapter(Context context,ArrayList<Money> monies){
        this.monies=monies;
        this.mContext=context;
    }

    @Override
    public int getCount() { //展示数据的长度
        return monies.size();
    }//数据的长度

    @Override
    public Money getItem(int position) {
        return monies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {      //第一次为空后续都不为空
            vHolder = null;
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_qq_money, null);
            vHolder = new ViewHolder();
            vHolder.moneyImg=convertView.findViewById(R.id.img);
            vHolder.moneyText=convertView.findViewById(R.id.name);
            convertView.setTag(vHolder);
        }else{
            vHolder = (ViewHolder)convertView.getTag();
        }
        vHolder.moneyImg.setImageResource(monies.get(position).getImg());
        vHolder.moneyText.setText(monies.get(position).getText());
        return convertView;
    }

    public class ViewHolder{
        private ImageView moneyImg;
        private TextView moneyText;
    }
}
