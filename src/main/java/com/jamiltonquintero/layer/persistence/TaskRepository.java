package com.jamiltonquintero.layer.persistence;


import com.jamiltonquintero.layer.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByIdIn(List<Long> tasksIds);

}