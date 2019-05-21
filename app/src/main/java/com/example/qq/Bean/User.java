package com.example.qq.Bean;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String userpwd;
    private String userzhanghao;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getUserzhanghao() {
        return userzhanghao;
    }

    public void setUserzhanghao(String userzhanghao) {
        this.userzhanghao = userzhanghao;
    }
}
