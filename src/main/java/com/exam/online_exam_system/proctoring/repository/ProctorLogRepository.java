package com.exam.online_exam_system.proctoring.repository;

import com.exam.online_exam_system.proctoring.entity.ProctorLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProctorLogRepository extends JpaRepository<ProctorLog, Long> {
}
