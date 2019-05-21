package com.example.qq.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;


import com.example.qq.Bean.Friend;
import com.example.qq.Utils.ToastUtil;
import com.example.qq.Widget.MyAlertDialog;
import com.example.qq.adapter.FriendAdapter;
import com.example.qq.R;

import java.util.ArrayList;

public class ChatActivity extends Activity {
    private ListView friendlistView;
    private ImageView imageViewHead;

    private ArrayList<Friend> friends = new ArrayList<>();
    private Context context =this;
    private FriendAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_qq_main); //绑定界面布局
        initDate();
        adapter = new FriendAdapter(context,friends);
        initView();
        setLister();
    }
    private void initView(){
        friendlistView = findViewById(R.id.friend_lv);
        friendlistView.setAdapter(adapter);
        imageViewHead = findViewById(R.id.user_imge);
    }
    private void initDate(){
        Friend friend1 = new Friend();
        friend1.setName("万炜");
        friend1.setMassage("呆久不");
        friend1.setDate("2019/3/25");
        friend1.setImage(R.drawable.a);
        Friend friend2 = new Friend();
        friend2.setName("黄子军");
        friend2.setMassage("撒由那拉");
        friend2.setDate("2019/3/25");
        friend2.setImage(R.drawable.b);
        Friend friend3 = new Friend();
        friend3.setName("余思远");
        friend3.setMassage("传奇走起");
        friend3.setDate("2019/3/28");
        friend3.setImage(R.drawable.c);
        Friend friend4 = new Friend();
        friend4.setName("于福文");
        friend4.setMassage("蛋炒饭");
        friend4.setDate("2019/3/28");
        friend4.setImage(R.drawable.a);
        Friend friend5 = new Friend();
        friend5.setName("卢志龙");
        friend5.setMassage("鸭扒");
        friend5.setDate("2019/3/28");
        friend5.setImage(R.drawable.c);
        Friend friend6 = new Friend();
        friend6.setName("张知成");
        friend6.setMassage("馄饨");
        friend6.setDate("2019/3/28");
        friend6.setImage(R.drawable.b);
        friends.add(friend1);
        friends.add(friend2);
        friends.add(friend3);
        friends.add(friend4);
        friends.add(friend5);
        friends.add(friend6);
        adapter = new FriendAdapter(context,friends);
    }

    //设置监听器
    public void setLister() {
        friendlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Friend friend = friends.get(position);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("abc",friend);
                intent.putExtras(bundle);
                intent.setClass(context,ChatFriendActivity.class);
                startActivity(intent);
            }
        });
        imageViewHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //changeHead();
                ToastUtil.getInstance().showToast(context,"我Android已经出师了");
            }
        });
        imageViewHead.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                MyAlertDialog dialog=new MyAlertDialog(context);
                dialog.show();
                return true;
            }
        });
    }

    public void changeHead() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);//设置不消失
        builder.setTitle("换头像");//设置弹窗标题
        builder.setMessage("你确定要退出当前页面吗？");//设置提示内容
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUtil.getInstance().showToast(context,"我确定要换头像");
            }
        });//设置确定键
        builder.setNegativeButton("取消",null);//设置确定键
        builder.create().show();//开始建造弹框，并弹出来
    }
}
