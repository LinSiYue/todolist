package com.sy.example.core.service.impl;

import com.sy.example.core.entity.User;
import com.sy.example.core.repository.UserRepository;
import com.sy.example.core.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User login(String name, String passWord) {
    return userRepository.findUserByNameAndPassWord(name, passWord);
  }

}
