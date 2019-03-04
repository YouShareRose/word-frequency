package com.fkit.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class User implements Serializable {
    private String loginname;
    private String password;
    private String username;

    // 对应上传的file，类型为MultipartFile，上传文件会自动绑定到image属性当中
    private MultipartFile image;

    public User(){

    }

    @Override
    public String toString() {
        return "User{" +
                "loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
