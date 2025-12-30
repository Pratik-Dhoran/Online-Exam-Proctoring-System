package com.exam.online_exam_system.result.service;

import com.exam.online_exam_system.result.entity.Result;

public interface ResultService {
    Result evaluateResult(Long attemptId);
}
