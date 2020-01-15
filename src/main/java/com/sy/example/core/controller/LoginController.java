package com.sy.example.core.controller;

import com.sy.example.comm.entity.ResultEntity;
import com.sy.example.comm.util.HttpStatusUtil;
import com.sy.example.core.dto.UserDTO;
import com.sy.example.core.entity.User;
import com.sy.example.core.service.UserLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(
    tags = {"User Login"},
    description = "user login api")
@RequestMapping("/user")
public class LoginController {

  @Autowired private UserLoginService userLoginService;

  @PostMapping("/login")
  @ApiOperation(value = "login", notes = "user login by nickName and passWord")
  public ResultEntity<Object> login(@RequestBody User user) {
    String userName = user.getUserName();
    String passWord = user.getPassWord();
    if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)) {
      return new ResultEntity<Object>(HttpStatusUtil.INPUT_NULL,null );
    } else {
      UserDTO userDTO = new UserDTO();
      userDTO = userLoginService.login(userName, passWord);
      if (userDTO != null) {
        return new ResultEntity<Object>(HttpStatusUtil.SUCCESS, userDTO);
      } else {
        return new ResultEntity<Object>(HttpStatusUtil.INPUT_MISTAKE, null);
      }
    }
  }

  @PostMapping("/logout")
  @ApiOperation(value = "logout", notes = "user logout")
  public ResultEntity<Object> login() {
    return new ResultEntity<Object>(HttpStatusUtil.SUCCESS, null);
  }
}
