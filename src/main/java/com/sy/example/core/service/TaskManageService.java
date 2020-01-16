package com.sy.example.core.service;

import com.sy.example.core.entity.Task;

import java.util.List;

public interface TaskManageService {

    List<Task> getAll();
    List<Task> getAllByParentProjectId(Integer parentProjectId);
    Task update(Task task);
}
