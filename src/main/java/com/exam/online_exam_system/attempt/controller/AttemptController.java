package com.exam.online_exam_system.attempt.controller;

import com.exam.online_exam_system.attempt.entity.Attempt;
import com.exam.online_exam_system.attempt.service.AttemptService;
import com.exam.online_exam_system.auth.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attempts")
public class AttemptController {

    @Autowired
    AttemptService attemptService;

    public AttemptController(AttemptService attemptService) {
        this.attemptService = attemptService;
    }

    @PostMapping("/start/{examId}")
    public Attempt startExam(@PathVariable Long examId,
                             @RequestHeader("Authorization") String authHeader) {

        String token = authHeader.substring(7);
        String email = JwtUtil.extractEmail(token);

        return attemptService.startExam(examId, email);
    }
}
