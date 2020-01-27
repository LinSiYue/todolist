package com.sy.example.core.repository;

import com.sy.example.core.entity.Project;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    List<Project> findAll();

    @Modifying
    @Transactional
    Project save(Project project);

    @Modifying
    @Transactional
    void deleteById(Integer id);

    @Query(value = "select max(id) from Project order by id desc")
    Integer findMaxId();
}
