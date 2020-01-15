package com.sy.example.core.service.impl;

import com.sy.example.core.convertor.UserDTOConvertor;
import com.sy.example.core.dto.UserDTO;
import com.sy.example.core.repository.UserRepository;
import com.sy.example.core.service.UserInfoManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoManageServiceImpl implements UserInfoManageService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO getInfoByName(String name) {
        return UserDTOConvertor.newBuilder()
                .setUser(userRepository.findUserByName(name))
                .userInfoBuild();
    }
}
