package com.exam.online_exam_system.result.repository;

import com.exam.online_exam_system.result.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result , Long> {
}
