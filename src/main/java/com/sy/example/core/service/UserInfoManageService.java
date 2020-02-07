package com.sy.example.core.service;

import com.sy.example.core.dto.UserDTO;
import com.sy.example.core.entity.User;

import java.util.List;

public interface UserInfoManageService {

    public UserDTO getInfoByName(String name);
    public List<String> getName(String query);
    public List<User> getAll();
    public User save(User user);
    public void deleteUserByName(String name);
    public void updatePassWordByName(String name, String passWord);
}
