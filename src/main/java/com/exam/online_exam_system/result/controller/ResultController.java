package com.exam.online_exam_system.result.controller;

import com.exam.online_exam_system.result.entity.Result;
import com.exam.online_exam_system.result.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    @Autowired
    ResultService resultService;

    @PostMapping("/evaluate/{attemptId}")
    public Result evaluate(@PathVariable Long attemptId) {
        return resultService.evaluateResult(attemptId);
    }
}
