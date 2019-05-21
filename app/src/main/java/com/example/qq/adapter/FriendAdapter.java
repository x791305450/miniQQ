package com.example.qq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qq.Bean.Friend;
import com.example.qq.R;

import java.util.ArrayList;

public class FriendAdapter extends BaseAdapter {
    private ArrayList<Friend> friends;
    private Context mContext;
    private ViewHolder vHolder;
    public FriendAdapter(Context context,ArrayList<Friend> friends2){
        this.friends=friends2;
        this.mContext=context;
    }

    @Override
    public int getCount() { //展示数据的长度
        return friends.size();
    }//数据的长度

    @Override
    public Friend getItem(int position) {
        return friends.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {      //第一次为空后续都不为空
            vHolder = null;
            convertView = LayoutInflater.from(mContext).inflate(R.layout.liaotian_qq, null);
            vHolder = new ViewHolder();
            vHolder.touxiang=convertView.findViewById(R.id.tx);
            vHolder.me=convertView.findViewById(R.id.me);
            vHolder.qq_mess=convertView.findViewById(R.id.qq_mess);
            vHolder.qq_times=convertView.findViewById(R.id.qq_times);
            convertView.setTag(vHolder);
        }else{
            vHolder = (ViewHolder)convertView.getTag();
        }
        vHolder.touxiang.setImageResource(friends.get(position).getImage());
        vHolder.me.setText(friends.get(position).getName());
        vHolder.qq_mess.setText(friends.get(position).getMassage());
        vHolder.qq_times.setText(friends.get(position).getDate());
        return convertView;
    }

    public class ViewHolder{
        private ImageView touxiang;
        private TextView me,qq_mess,qq_times;
    }

}
