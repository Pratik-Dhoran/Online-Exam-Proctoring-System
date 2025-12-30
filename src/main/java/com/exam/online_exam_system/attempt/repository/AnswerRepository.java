package com.exam.online_exam_system.attempt.repository;

import com.exam.online_exam_system.attempt.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
