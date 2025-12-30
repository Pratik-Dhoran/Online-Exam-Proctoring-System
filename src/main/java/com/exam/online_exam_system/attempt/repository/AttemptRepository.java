package com.exam.online_exam_system.attempt.repository;

import com.exam.online_exam_system.attempt.entity.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Long> {
}
