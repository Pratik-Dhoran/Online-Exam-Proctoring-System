package com.exam.online_exam_system.exam.repository;

import com.exam.online_exam_system.exam.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
