package com.smartcampus.repository;

import com.smartcampus.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    List<Assignment> findByDifficulty(String difficulty);

    List<Assignment> findByTopic(String topic);
}