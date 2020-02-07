package com.sy.example.core.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {

    private String name;
    private String role;
    private String phone;

    public UserVO() {
    }

    public UserVO(String name, String role, String phone) {
        this.name = name;
        this.role = role;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
