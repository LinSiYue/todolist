package com.sy.example.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_user")
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 32)
    private String nickName;

    @Column(length = 16)
    private String passWord;

    @Column(length = 11)
    private String phone;

    public User() {
    }

    public User(String nickName, String passWord, String phone) {
        this.nickName = nickName;
        this.passWord = passWord;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
