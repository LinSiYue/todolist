package com.sy.example.core.service.impl;

import com.sy.example.core.entity.Project;
import com.sy.example.core.repository.ProjectRepository;
import com.sy.example.core.service.ProjectManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectManageServiceImpl implements ProjectManageService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }
}
