package com.sy.example.core.service;

import com.sy.example.core.dto.UserDTO;

import java.util.List;

public interface UserInfoManageService {

    public UserDTO getInfoByName(String name);
    public List<String> getAllName();
}
