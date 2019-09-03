package com.sy.example.core.service.impl;

import com.sy.example.core.convertor.UserDTOConvertor;
import com.sy.example.core.dto.UserDTO;
import com.sy.example.core.repository.UserRepository;
import com.sy.example.core.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserLoginServiceImpl implements UserLoginService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDTO login(String nickName, String passWord) {
    return UserDTOConvertor.newBuilder()
        .setUser(userRepository.findUserByNickNameAndPassWord(nickName, passWord))
        .build();
  }
}
