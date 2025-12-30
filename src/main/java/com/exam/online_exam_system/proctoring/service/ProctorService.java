package com.exam.online_exam_system.proctoring.service;

public interface ProctorService {
    void logEvent(Long attemptId, String eventType, String details);
}
