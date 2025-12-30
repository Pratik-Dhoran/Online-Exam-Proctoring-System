package com.exam.online_exam_system.attempt.service;

import com.exam.online_exam_system.attempt.entity.Attempt;

public interface AttemptService {
    Attempt startExam(Long examId, String userEmail);
}
