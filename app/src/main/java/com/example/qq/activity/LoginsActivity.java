package com.example.qq.activity;


import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qq.Bean.User;
import com.example.qq.R;
import com.example.qq.Utils.JsonUtil;
import com.example.qq.Utils.PerferencesUtil;
import com.example.qq.Utils.http.RequestManger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginsActivity extends AppCompatActivity {
    private TextView qq_tv;
    private EditText qq_zhanghao_ed;
    private EditText qq_pwd_ed;
    private Button login_bt;
    private CheckBox user_xieyi_cx;
    private TextView loginInfoTv;
    private Context mContext = this;
    private LinearLayout layout;
    private String userinfo="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();//初始化控件
        setLister();//设置监听器
        initDataView();
    }

    //设置监听器
    public void setLister() {
        qq_pwd_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                s = s.toString();
                if (s.length() >= 6 && user_xieyi_cx.isChecked()) {
                    login_bt.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                    login_bt.setClickable(true);
                } else if (s.length() < 6) {
                    login_bt.setBackgroundColor(getResources().getColor(R.color.colorGrey));
                    login_bt.setClickable(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user_xieyi_cx.isChecked()==true){
                    String getZhanghao=qq_zhanghao_ed.getText().toString();
                    String getPwd=qq_pwd_ed.getText().toString();

                    User user=new User();
                    user.setUserpwd(getPwd);
                    user.setUserzhanghao(getZhanghao);
                    user.setUsername("蔡徐坤");
                    String userJson=JsonUtil.getInstance().beanToJson(user);
                    if(userJson==null||userJson==""){
                        loginInfoTv.setText("蔡徐坤是空的");
                    }else {
                        Log.e("cxk",userJson);
                        loginInfoTv.setText(userJson);
                        PerferencesUtil.getInstance(mContext).saveData("cxk",userJson);
                        writeData(userJson,"context.text");
                    }
                }else{
                    showToast("没有勾选用户协议！");
                }
                String url="https://www.baidu.com";
                RequestManger.getInstance().getSever(url);
            }
        });
    }

    //初始化控件
    private void initView() {
        qq_tv = findViewById(R.id.qq_tv);
        qq_zhanghao_ed = findViewById(R.id.qq_zhanghao_ed);
        qq_pwd_ed = findViewById(R.id.qq_pwd_ed);
        login_bt = findViewById(R.id.login_bt);
        user_xieyi_cx = findViewById(R.id.user_xieyi_cx);
        layout=findViewById(R.id.all_layout);
        loginInfoTv=findViewById(R.id.loginInfoTV);
    }

    public void showToast(String ts){
        Toast.makeText(mContext,ts,Toast.LENGTH_LONG).show();
    }

    public void initDataView(){
        User user=null;
        userinfo=readData("content.txt");
        user =JsonUtil.getInstance().jsonToBean(userinfo,User.class);
        if (user!=null){
            qq_zhanghao_ed.setText(user.getUserzhanghao());
            qq_pwd_ed.setText(user.getUserpwd());
        }else{
            showToast("解析失败");
        }
    }
    public void writeData(String datainfo,String filename){
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=openFileOutput(filename,Context.MODE_APPEND);
            if (fileOutputStream!=null){
                fileOutputStream.write(datainfo.getBytes());
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                fileOutputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public  String readData(String fileName){
        String  data ="";
        try {
            FileInputStream fileInputStream;
            fileInputStream = openFileInput(fileName);
            StringBuffer stringBuffer = new StringBuffer("");
            BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = new String();
            //读取每一行数据，并追加到StringBuilder对象中，直到结束
            while ((line = reader.readLine()) != null) {
                stringBuffer.append(line);
            }
            data = stringBuffer.toString();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  data;
    }
}

