package com.sy.example.core.repository;

import com.sy.example.core.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByNickNameAndPassWord(String nickName, String passWord);

}