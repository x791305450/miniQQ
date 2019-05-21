package com.example.qq.Bean;

import java.io.Serializable;

public class FriendZone implements Serializable {
    private int userImg;
    private String userName;
    private int contentImg;
    private String contentText;

    public int getUserImg() {
        return userImg;
    }

    public void setUserImg(int userImg) {
        this.userImg = userImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getContentImg() {
        return contentImg;
    }

    public void setContentImg(int contentImg) {
        this.contentImg = contentImg;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }
}
