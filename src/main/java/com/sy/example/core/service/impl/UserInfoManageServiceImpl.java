package com.sy.example.core.service.impl;

import com.sy.example.comm.utils.RedisUtil;
import com.sy.example.core.convertor.UserDTOConvertor;
import com.sy.example.core.dto.UserDTO;
import com.sy.example.core.entity.User;
import com.sy.example.core.repository.UserRepository;
import com.sy.example.core.service.UserInfoManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoManageServiceImpl implements UserInfoManageService {

    @Autowired
    private UserRepository userRepository;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public UserDTO getInfoByName(String name) {
        return UserDTOConvertor.newBuilder()
                .setUser(userRepository.findUserByName(name))
                .userInfoBuild(redisUtil.get(name).toString());
    }

    @Override
    public List<String> getName(String query) {
        return userRepository.findNameByQuery(query);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserByName(String name) {
        userRepository.deleteUserByName(name);
    }

    @Override
    public void updatePassWordByName(String name, String passWord) {
        userRepository.updatePassWordByName(name, passWord);
    }
}
