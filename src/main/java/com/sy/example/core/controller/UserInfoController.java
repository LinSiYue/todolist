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
@RequestMapping("/user")
@Api(
    tags = {"Get User Info"},
    description = "get user info api")
public class UserInfoController {

  @Autowired private UserLoginService userLoginService;

  @GetMapping("/getInfo")
  @ApiOperation(value = "getUserInfo", notes = "get user info")
  public ResultEntity<Object> getUserInfo(@RequestParam(value = "userName") String userName, @RequestParam(value = "token") String token) {

    if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(token)) {
      return new ResultEntity<Object>(HttpStatusUtil.INPUT_NULL, null);
    } else {
      UserDTO userDTO = new UserDTO();
      userDTO = userLoginService.getInfoByUserName(userName);
      if (userDTO != null) {
        return new ResultEntity<Object>(HttpStatusUtil.SUCCESS, userDTO);
      } else {
        return new ResultEntity<Object>(HttpStatusUtil.INPUT_MISTAKE, null);
      }
    }
  }
}
