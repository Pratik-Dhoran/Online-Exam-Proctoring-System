package com.exam.online_exam_system.attempt.controller;

import com.exam.online_exam_system.attempt.entity.Attempt;
import com.exam.online_exam_system.attempt.service.AttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attempts")
public class AttemptController {

    @Autowired
    AttemptService attemptService;

    @PostMapping("/start/{examId}")
    public Attempt startExam(@PathVariable Long examId,
                             @RequestParam String email) {

        return attemptService.startExam(examId, email);
    }

    @PostMapping("/submit/{attemptId}")
    public String submitExam(@PathVariable Long attemptId) {
        attemptService.submitExam(attemptId);
        return "Exam submitted successfully";
    }
}
