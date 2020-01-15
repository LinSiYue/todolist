package com.sy.example.core.controller;

import com.sy.example.comm.entity.ResultEntity;
import com.sy.example.comm.enums.HttpStatusEnums;
import com.sy.example.core.service.TaskManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
@Api(
    tags = {"Get Task Info"},
    description = "get task info api")
public class TaskController {

    @Autowired
    private TaskManageService taskManageService;

    @GetMapping("/all")
    @ApiOperation(value = "getAllTaskInfo", notes = "get all task info")
    public ResultEntity<Object> getAll() {

        try {
            System.out.println(taskManageService.getAll());
            return new ResultEntity<>(HttpStatusEnums.SUCCESS, taskManageService.getAll());
        } catch (Exception e) {
            return new ResultEntity<>(HttpStatusEnums.ERROR, null);
        }
    }

}
