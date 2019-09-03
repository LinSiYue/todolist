package com.sy.example.admin.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin {

    private int id;
    private String nickName;
    private String passWord;
    private String phone;

    public Admin() {
    }

    public Admin(String nickName, String passWord, String phone) {
        this.nickName = nickName;
        this.passWord = passWord;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
