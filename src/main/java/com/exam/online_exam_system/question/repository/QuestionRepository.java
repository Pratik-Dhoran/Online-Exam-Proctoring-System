package com.exam.online_exam_system.question.repository;

import com.exam.online_exam_system.question.entity.Question;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
