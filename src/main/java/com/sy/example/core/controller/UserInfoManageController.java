package com.sy.example.core.controller;

import com.sy.example.comm.entity.ResultEntity;
import com.sy.example.comm.enums.HttpStatusEnums;
import com.sy.example.core.dto.UserDTO;
import com.sy.example.core.entity.User;
import com.sy.example.core.service.UserInfoManageService;
import com.sy.example.core.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(
        tags = {"Get User Info"},
        description = "get user info api")
public class UserInfoManageController {

    @Autowired
    private UserInfoManageService userInfoManageService;

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

    @GetMapping("/getName/{query}")
    @ApiOperation(value = "getAllUserName", notes = "get all users name")
    public ResultEntity<List<String>> getAllName(@PathVariable("query") String query) {
        try {
            return new ResultEntity<>(HttpStatusEnums.SUCCESS, userInfoManageService.getName(query));
        } catch (Exception e) {
            return new ResultEntity<>(HttpStatusEnums.ERROR, null);
        }
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "getAllUser", notes = "get all users")
    public ResultEntity<List<UserVO>> getAll() {
        try {
            List<User> list = userInfoManageService.getAll();
            List<UserVO> userVO = new ArrayList<>();
            for (User user : list) {
                if (!user.getRoles().equals("admin")) {
                    userVO.add(new UserVO(user.getName(), user.getRoles(), user.getPhone()));
                }
            }
            return new ResultEntity<>(HttpStatusEnums.SUCCESS, userVO);
        } catch (Exception e) {
            return new ResultEntity<>(HttpStatusEnums.ERROR, null);
        }
    }

    @DeleteMapping("/delete/{name}")
    @ApiOperation(value = "deleteUserByName", notes = "delete user by name")
    public ResultEntity<String> deleteByName(@PathVariable(value = "name") String name) {
        try {
            userInfoManageService.deleteUserByName(name);
            return new ResultEntity<>(HttpStatusEnums.SUCCESS, name);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultEntity<>(HttpStatusEnums.ERROR, null);
        }
    }

    @PostMapping("/resetPassWord")
    @ApiOperation(value = "resetPassWord", notes = "reset passWord by name")
    public ResultEntity<String> changePassWord(@RequestParam(value = "name") String name,
                                               @RequestParam(value = "passWord") String passWord) {
        try {
            userInfoManageService.resetPassWord(name, passWord);
            return new ResultEntity<>(HttpStatusEnums.SUCCESS, name);
        } catch (Exception e) {
            return new ResultEntity<>(HttpStatusEnums.ERROR, null);
        }
    }

    @PostMapping("/changePassWord")
    @ApiOperation(value = "changePassWord", notes = "change passWord by name")
    public ResultEntity<String> changePassWord(@RequestParam(value = "name") String name, @RequestParam(value = "oldPassWord") String oldPassWord, @RequestParam(value = "newPassWord") String newPassWord) {
        try {
            if(!(StringUtils.isEmpty(oldPassWord) || StringUtils.isEmpty(newPassWord))) {
                if(userInfoManageService.changePassWord(name, oldPassWord, newPassWord) > 0) {
                    return new ResultEntity<>(HttpStatusEnums.SUCCESS, name);
                } else {
                    return new ResultEntity<>(HttpStatusEnums.SUCCESS, null);
                }
            } else {
                return new ResultEntity<>(HttpStatusEnums.INPUT_NULL, null);
            }
        } catch (Exception e) {
            return new ResultEntity<>(HttpStatusEnums.ERROR, null);
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "saveUser", notes = "save user")
    public ResultEntity<UserVO> saveUser(@RequestBody User user) {
        try {
            if (!(StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassWord()) || StringUtils.isEmpty(user.getRoles()))) {
                User userResult = userInfoManageService.save(user);
                UserVO userVO = new UserVO(userResult.getName(), userResult.getRoles(), userResult.getPhone());
                return new ResultEntity<>(HttpStatusEnums.SUCCESS, userVO);
            } else {
                return new ResultEntity<>(HttpStatusEnums.INPUT_NULL, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultEntity<>(HttpStatusEnums.ERROR, null);
        }
    }

}
