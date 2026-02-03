package com.exam.online_exam_system.proctoring.service.impl;

import com.exam.online_exam_system.attempt.entity.Attempt;
import com.exam.online_exam_system.attempt.repository.AttemptRepository;
import com.exam.online_exam_system.common.exception.ApiException;
import com.exam.online_exam_system.proctoring.entity.ProctorLog;
import com.exam.online_exam_system.proctoring.repository.ProctorLogRepository;
import com.exam.online_exam_system.proctoring.service.ProctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProctorServiceImpl implements ProctorService {

    @Autowired
    ProctorLogRepository proctorLogRepository;

    @Autowired
    AttemptRepository attemptRepository;

    @Override
    public void logEvent(Long attemptId, String eventType, String details) {

        // 1) Find attempt
        Attempt attempt = attemptRepository.findById(attemptId)
                .orElseThrow(() -> new ApiException("Attempt not found"));

        // 2) Save the proctor log
        ProctorLog log = new ProctorLog();
        log.setAttempt(attempt);
        log.setEventType(eventType);
        log.setEventTime(LocalDateTime.now());
        log.setDetails(details);

        proctorLogRepository.save(log);

        // 3) Simple risk scoring logic (BEGINNER FRIENDLY)
        int riskPoints = 0;

        if ("TAB_SWITCH".equals(eventType)) {
            riskPoints = 10;
        }
        else if ("FULLSCREEN_EXIT".equals(eventType)) {
            riskPoints = 20;
        }

        // 4) Update attempt risk score
        int newRisk = attempt.getRiskScore() + riskPoints;
        attempt.setRiskScore(newRisk);

        attemptRepository.save(attempt);
    }
}
