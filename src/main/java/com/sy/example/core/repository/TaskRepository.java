package com.sy.example.core.repository;

import com.sy.example.core.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAll();
    List<Task> findAllByParentProjectId(Integer parentProjectId);

    @Modifying
    @Transactional
    Task save(Task task);

    @Modifying
    @Transactional
    @Query(value = "delete from Task where id = ?1")
    void deleteById(Integer id);
}
