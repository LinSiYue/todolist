package com.sy.example.core.controller;

import com.sy.example.comm.entity.ResultEntity;
import com.sy.example.comm.enums.HttpStatusEnums;
import com.sy.example.core.entity.Task;
import com.sy.example.core.service.TaskManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@Api(
    tags = {"Get Task Info"},
    description = "get task info api")
public class TaskController {

  @Autowired private TaskManageService taskManageService;

  @GetMapping("/by-projectId/{projectId}")
  @ApiOperation(value = "findAllTaskByParentProjectId", notes = "find all task by parentProjectId")
  public ResultEntity<List<Task>> getAllByParentProjectId(
          @PathVariable(name = "projectId") String projectId) {
    try {
      return new ResultEntity<>(
              HttpStatusEnums.SUCCESS, taskManageService.getAllByParentProjectId(Integer.parseInt(projectId)));
    } catch (Exception e) {
      return new ResultEntity<>(HttpStatusEnums.ERROR, null);
    }
  }

  @GetMapping("/all")
  @ApiOperation(value = "getAllTaskInfo", notes = "get all task info")
  public ResultEntity<List<Task>> getAll() {

    try {
      return new ResultEntity<>(HttpStatusEnums.SUCCESS, taskManageService.getAll());
    } catch (Exception e) {
      return new ResultEntity<>(HttpStatusEnums.ERROR, null);
    }
  }

  @PostMapping("/{id}")
  @ApiOperation(value = "updateTaskInfo", notes = "update task info")
  public ResultEntity<Task> update(@RequestBody Task task) {
    try {
      return new ResultEntity<>(HttpStatusEnums.SUCCESS, taskManageService.update(task));
    } catch (Exception e) {
      return new ResultEntity<>(HttpStatusEnums.ERROR, null);
    }
  }

}
