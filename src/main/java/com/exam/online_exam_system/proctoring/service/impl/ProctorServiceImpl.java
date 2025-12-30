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

        Attempt attempt = attemptRepository.findById(attemptId)
                .orElseThrow(() -> new ApiException("Attempt not found"));

        ProctorLog log = new ProctorLog();
        log.setAttempt(attempt);
        log.setEventType(eventType);
        log.setEventTime(LocalDateTime.now());
        log.setDetails(details);

        proctorLogRepository.save(log);
    }
}
