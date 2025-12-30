package com.exam.online_exam_system.attempt.controller;

import com.exam.online_exam_system.attempt.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @PostMapping("/submit")
    public void submitAnswer(@RequestParam Long attemptId,
                             @RequestParam Long questionId,
                             @RequestParam Long optionId) {

        answerService.submitAnswer(attemptId, questionId, optionId);
    }
}
