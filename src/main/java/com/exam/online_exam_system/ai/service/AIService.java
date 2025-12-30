package com.exam.online_exam_system.ai.service;

import com.exam.online_exam_system.ai.entity.AIReport;

public interface AIService {
    AIReport generateReport(Long attemptId);
}
