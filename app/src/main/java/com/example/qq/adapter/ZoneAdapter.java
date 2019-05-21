package com.example.qq.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.qq.Bean.FriendZone;
import com.example.qq.R;
import com.example.qq.Utils.ToastUtil;

import java.util.ArrayList;

public class ZoneAdapter extends RecyclerView.Adapter<ZoneAdapter.ViewHolder> {
    private ArrayList<FriendZone> friendZones;
    private Context mContext;

    public ZoneAdapter(Context context,ArrayList<FriendZone> friendZones1){
        this.mContext=context;
        this.friendZones=friendZones1;
    }

    public ArrayList<FriendZone> getFriendZones() {
        return friendZones;
    }

    public void setFriendZones(ArrayList<FriendZone> friendZones) {
        this.friendZones = friendZones;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override//确定样式
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View convertView=null;
        LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.item_qq_zone,null);
        return new ViewHolder(convertView);
    }

    @Override//数据填充 i=position
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.userHolderImg.setImageResource(friendZones.get(position).getUserImg());
        viewHolder.contentImg.setImageResource(friendZones.get(position).getContentImg());
        viewHolder.userHolderImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.getInstance().showToast(mContext,"食屎拉你！！！");
            }
        });
    }

    @Override
    public int getItemCount() {//确定数据条目
        return friendZones.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView userHolderImg;
        private ImageView contentImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userHolderImg=itemView.findViewById(R.id.user_head);
            contentImg=itemView.findViewById(R.id.neirong_img);
        }
    }
}
