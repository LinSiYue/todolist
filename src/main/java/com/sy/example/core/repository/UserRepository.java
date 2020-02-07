package com.sy.example.core.repository;

import com.sy.example.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByNameAndPassWord(String name, String passWord);
    User findUserByName(String name);
    List<User> findAll();

    @Modifying
    @Transactional
    void deleteUserByName(String name);

    @Modifying
    @Transactional
    User save(User user);

    @Modifying
    @Transactional
    @Query(value = "update User set pass_word = ?2 where name=?1")
    void updatePassWordByName(String name, String passWord);

    @Query(value = "select name from User where name like %?1%")
    List<String> findNameByQuery(String query);
}
