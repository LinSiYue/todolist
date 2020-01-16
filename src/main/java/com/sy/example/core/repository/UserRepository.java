package com.sy.example.core.repository;

import com.sy.example.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByNameAndPassWord(String name, String passWord);
    User findUserByName(String name);

    @Query(value = "select name from User")
    List<String> findName();
}
