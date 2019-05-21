package com.example.qq.Widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qq.R;
import com.example.qq.Utils.ToastUtil;

public class MyAlertDialog extends Dialog {
    private Button buttonOK;
    private Button buttonCanel;
    private TextView messageText;
    private ImageView iconImg;
    private Context mContext;
    private View.OnClickListener listener1;
    private View.OnClickListener listener2;
    private String message;
    private int Imagesrc;
    public MyAlertDialog(Context context) {
        super(context);
        this.mContext=context;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_dialog);
        messageText=findViewById(R.id.dialog_message);
        iconImg=findViewById(R.id.dialog_img);
        buttonOK=findViewById(R.id.btn_ok);
        buttonOK.setOnClickListener(listener1);
        buttonCanel=findViewById(R.id.btn_cancel);
        buttonCanel.setOnClickListener(listener2);
        messageText.setText(message);
        iconImg.setImageResource(Imagesrc);
    }

    public View.OnClickListener getListener1() {
        return listener1;
    }

    public void setListener1(View.OnClickListener listener1) {
        this.listener1 = listener1;
    }

    public View.OnClickListener getListener2() {
        return listener2;
    }

    public void setListener2(View.OnClickListener listener2) {
        this.listener2 = listener2;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getImagesrc() {
        return Imagesrc;
    }

    public void setImagesrc(int imagesrc) {
        Imagesrc = imagesrc;
    }
}
