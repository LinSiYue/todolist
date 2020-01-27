package com.sy.example.core.service;

import com.sy.example.core.entity.Project;

import java.util.List;

public interface ProjectManageService {

    List<Project> getAll();
    Project save(Project project);
    List<Project> getProjectByMember(String member);
    void delById(Integer id);
    Integer getMaxId();
}
