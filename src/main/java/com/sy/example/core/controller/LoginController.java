package com.sy.example.core.controller;

import com.sy.example.core.dto.UserDTO;
import com.sy.example.core.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(String nickName, String passWord) {

        if(StringUtils.isEmpty(nickName) || StringUtils.isEmpty(passWord)) {
            return new ResponseEntity<>("Input is null.", HttpStatus.BAD_REQUEST);
        }else {
            UserDTO userDTO = new UserDTO();
            userDTO = userLoginService.login(nickName, passWord);

            if(userDTO != null){
                return new ResponseEntity<>(userDTO, HttpStatus.OK);
            }else {
                return new ResponseEntity<>("NickName or Password is mistake.", HttpStatus.BAD_REQUEST);
            }
        }

    }

}
