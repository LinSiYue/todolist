package com.sy.example.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "t_user")
@Setter
@Getter
@ApiModel(description="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "userID")
    private int id;

    @Column(length = 32)
    @ApiModelProperty(value = "userName")
    private String userName;

    @Column(length = 16)
    @ApiModelProperty(value = "userPassWord")
    private String passWord;

    @Column(length = 11)
    @ApiModelProperty(value = "userPhone")
    private String phone;

    @Column(length = 11)
    @ApiModelProperty(value = "roles")
    private String roles;

    @Column(length = 32)
    @ApiModelProperty(value = "introduction")
    private String introduction;

    @Column(length = 255)
    @ApiModelProperty(value = "avatar")
    private String avatar;

    public User() {
    }

    public User(String userName, String passWord, String phone, String roles, String introduction, String avatar) {
        this.userName = userName;
        this.passWord = passWord;
        this.phone = phone;
        this.roles = roles;
        this.introduction = introduction;
        this.avatar = avatar;
    }

    public User(String userName, String phone, String roles, String introduction, String avatar) {
        this.userName = userName;
        this.passWord = passWord;
        this.phone = phone;
        this.roles = roles;
        this.introduction = introduction;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phone='" + phone + '\'' +
                ", roles='" + roles + '\'' +
                ", introduction='" + introduction + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
