package com.sy.example.core.controller;

import com.sy.example.comm.entity.ResultEntity;
import com.sy.example.comm.enums.HttpStatusEnums;
import com.sy.example.core.dto.UserDTO;
import com.sy.example.core.service.UserInfoManageService;
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
public class UserInfoManageController {

  @Autowired private UserInfoManageService userInfoManageService;

  @GetMapping("/getInfo")
  @ApiOperation(value = "getUserInfo", notes = "get user info")
  public ResultEntity<Object> getUserInfo(
      @RequestParam(value = "name") String userName, @RequestParam(value = "token") String token) {
    try {
      if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(token)) {
        return new ResultEntity<Object>(HttpStatusEnums.INPUT_NULL, null);
      } else {
        UserDTO userDTO = new UserDTO();
        userDTO = userInfoManageService.getInfoByName(userName);
        if (userDTO != null) {
          return new ResultEntity<Object>(HttpStatusEnums.SUCCESS, userDTO);
        } else {
          return new ResultEntity<Object>(HttpStatusEnums.INPUT_MISTAKE, null);
        }
      }
    } catch (Exception e) {
      return new ResultEntity<Object>(HttpStatusEnums.ERROR, null);
    }
  }
}
