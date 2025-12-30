package com.exam.online_exam_system.ai.service.impl;

import com.exam.online_exam_system.ai.entity.AIReport;
import com.exam.online_exam_system.ai.repository.AIReportRepository;
import com.exam.online_exam_system.ai.service.AIService;
import com.exam.online_exam_system.attempt.entity.Attempt;
import com.exam.online_exam_system.attempt.repository.AttemptRepository;
import com.exam.online_exam_system.common.exception.ApiException;
import com.exam.online_exam_system.proctoring.entity.ProctorLog;
import com.exam.online_exam_system.proctoring.repository.ProctorLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AIServiceImpl implements AIService {

    @Autowired
    ProctorLogRepository proctorLogRepository;
    @Autowired
    AttemptRepository attemptRepository;
    @Autowired
    AIReportRepository aiReportRepository;

    @Override
    public AIReport generateReport(Long attemptId) {

        Attempt attempt = attemptRepository.findById(attemptId)
                .orElseThrow(() -> new ApiException("Attempt not found"));

        List<ProctorLog> logs = proctorLogRepository.findAll()
                .stream()
                .filter(l -> l.getAttempt().getId().equals(attemptId))
                .toList();

        int score = 0;

        for (ProctorLog log : logs) {
            switch (log.getEventType()) {
                case "TAB_SWITCH" -> score += 10;
                case "FULLSCREEN_EXIT" -> score += 15;
                case "COPY" -> score += 20;
                case "PASTE" -> score += 20;
                case "NO_ACTIVITY" -> score += 5;
            }
        }

        String level = score >= 50 ? "HIGH" : score >= 25 ? "MEDIUM" : "LOW";

        String summary = "Detected " + logs.size() + " suspicious activities. Risk Level: " + level;

        AIReport report = new AIReport();
        report.setAttempt(attempt);
        report.setRiskScore(score);
        report.setRiskLevel(level);
        report.setSummary(summary);

        return aiReportRepository.save(report);
    }
}
