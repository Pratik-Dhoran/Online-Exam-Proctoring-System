package com.exam.online_exam_system.attempt.service.impl;

import com.exam.online_exam_system.attempt.entity.Attempt;
import com.exam.online_exam_system.attempt.repository.AttemptRepository;
import com.exam.online_exam_system.attempt.service.AttemptService;
import com.exam.online_exam_system.common.exception.ApiException;
import com.exam.online_exam_system.exam.entity.Exam;
import com.exam.online_exam_system.exam.repository.ExamRepository;
import com.exam.online_exam_system.user.entity.User;
import com.exam.online_exam_system.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AttemptServiceImpl implements AttemptService {

    @Autowired
    AttemptRepository attemptRepository;

    @Autowired
    ExamRepository examRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Attempt startExam(Long examId, String userEmail) {

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ApiException("User not found"));

        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new ApiException("Exam not found"));

        Attempt attempt = new Attempt();
        attempt.setUser(user);
        attempt.setExam(exam);
        attempt.setStartTime(LocalDateTime.now());
        attempt.setStatus("IN_PROGRESS");

        return attemptRepository.save(attempt);
    }

    // ----- MANUAL SUBMIT -----
    public void submitExam(Long attemptId) {

        Attempt attempt = attemptRepository.findById(attemptId)
                .orElseThrow(() -> new ApiException("Attempt not found"));

        // Prevent double submit
        if (!attempt.getStatus().equals("IN_PROGRESS")) {
            throw new ApiException("Exam already submitted or timed out");
        }

        attempt.setEndTime(LocalDateTime.now());
        attempt.setStatus("SUBMITTED");

        attemptRepository.save(attempt);
    }

    // ----- BACKEND AUTO-SUBMIT HELPER -----
    public void autoSubmit(Attempt attempt) {

        attempt.setStatus("TIMEOUT");
        attempt.setEndTime(LocalDateTime.now());
        attemptRepository.save(attempt);
    }
}
