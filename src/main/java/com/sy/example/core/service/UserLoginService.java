package com.sy.example.core.service;

import com.sy.example.core.dto.UserDTO;

public interface UserLoginService {

    public UserDTO login(String name, String passWord);

}
