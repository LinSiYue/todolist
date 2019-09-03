package com.sy.example.core.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String nickName;
    private String phone;

    public UserDTO() {
    }

    public UserDTO(String nickName, String phone) {
        this.nickName = nickName;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
