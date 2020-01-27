package com.sy.example.core.service.impl;

import com.sy.example.core.entity.Project;
import com.sy.example.core.repository.ProjectRepository;
import com.sy.example.core.service.ProjectManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectManageServiceImpl implements ProjectManageService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getProjectByMember(String member) {
        List<Project> projects = new ArrayList<>();
        List<Project> list = projectRepository.findAll();
        for(Project project : list) {
            for(String c : project.getMember().split(",")){
                if(c.equals(member)){
                    projects.add(project);
                }
            }
        }
        return projects;
    }

    @Override
    public void delById(Integer id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Integer getMaxId() {
        return projectRepository.findMaxId();
    }
}
