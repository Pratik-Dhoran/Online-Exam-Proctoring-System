package com.exam.online_exam_system.ai.repository;

import com.exam.online_exam_system.ai.entity.AIReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AIReportRepository extends JpaRepository<AIReport, Long> {
}
