package com.example.qq.Bean;

import java.io.Serializable;

public class Money implements Serializable {
    private int img;
    private String text;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
