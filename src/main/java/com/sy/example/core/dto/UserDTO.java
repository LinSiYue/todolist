package com.sy.example.core.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String name;
    private String phone;
    private String token;
    private String roles;
    private String introduction;
    private String avatar;

    public UserDTO() {
    }

    public UserDTO(String name, String token) {
        this.name = name;
        this.token = token;
    }

    public UserDTO(String name, String phone, String token, String roles, String introduction, String avatar) {
        this.name = name;
        this.phone = phone;
        this.token = token;
        this.roles = roles;
        this.introduction = introduction;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userName='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", token='" + token + '\'' +
                ", roles='" + roles + '\'' +
                ", introduction='" + introduction + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
