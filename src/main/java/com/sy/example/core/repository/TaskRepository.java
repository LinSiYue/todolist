package com.sy.example.core.repository;

import com.sy.example.core.entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findAll();
    List<Task> findAllByParentProjectId(Integer parentProjectId);
    Task save(Task task);
}
