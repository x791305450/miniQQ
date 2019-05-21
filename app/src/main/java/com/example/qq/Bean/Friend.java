package com.example.qq.Bean;

import java.io.Serializable;

public class Friend implements Serializable {
    private int image;  //头像
    private String name; //昵称
    private String massage; //消息
    private String date;    //聊天日期

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
