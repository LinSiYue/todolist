package com.sy.example.core.service.impl;

import com.sy.example.core.dto.TaskDTO;
import com.sy.example.core.entity.Task;
import com.sy.example.core.repository.TaskRepository;
import com.sy.example.core.service.TaskManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskManageServiceImpl implements TaskManageService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getAllByParentProjectId(Integer parentProjectId) {
        return taskRepository.findAllByParentProjectId(parentProjectId);
    }

    @Override
    public Task update(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void delById(Integer id) {
        try{
            taskRepository.deleteById(id);
        }catch (Exception e) {
            System.out.println(e);
        }
    }

}
