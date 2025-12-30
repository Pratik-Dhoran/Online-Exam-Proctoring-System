package com.exam.online_exam_system.question.repository;

import com.exam.online_exam_system.question.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Option,Long> {
}
