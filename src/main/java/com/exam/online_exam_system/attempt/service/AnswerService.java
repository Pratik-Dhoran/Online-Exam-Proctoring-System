package com.exam.online_exam_system.attempt.service;

public interface AnswerService {
    void submitAnswer(Long attemptId, Long questionId, Long optionId);
}
