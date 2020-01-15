package com.sy.example.core.controller;

import com.sy.example.comm.entity.ResultEntity;
import com.sy.example.comm.enums.HttpStatusEnums;
import com.sy.example.core.entity.Project;
import com.sy.example.core.service.ProjectManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/project")
@Api(
    tags = {"Get Project Info"},
    description = "get project info api")
public class ProjectManageController {

  @Autowired private ProjectManageService projectManageService;

  @GetMapping("/all")
  @ApiOperation(value = "getAllProjectInfo", notes = "get all project info")
  public ResultEntity<List<Project>> getAll() {
    try {
      return new ResultEntity<>(HttpStatusEnums.SUCCESS, projectManageService.getAll());
    } catch (Exception e) {
      return new ResultEntity<>(HttpStatusEnums.ERROR, null);
    }
  }
}
