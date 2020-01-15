package com.sy.example.core.repository;

import com.sy.example.core.entity.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    List<Project> findAll();

}
