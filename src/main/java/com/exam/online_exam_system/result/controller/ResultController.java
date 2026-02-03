package com.exam.online_exam_system.result.controller;

import com.exam.online_exam_system.common.dto.ResultResponse;
import com.exam.online_exam_system.result.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    @Autowired
    ResultService resultService;

    @GetMapping("/{attemptId}")
    public ResultResponse getResult(@PathVariable Long attemptId) {
        return resultService.calculateResult(attemptId);
    }
}
