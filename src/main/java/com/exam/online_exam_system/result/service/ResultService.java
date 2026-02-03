package com.exam.online_exam_system.result.service;

import com.exam.online_exam_system.common.dto.ResultResponse;

public interface ResultService {
    ResultResponse calculateResult(Long attemptId);
}
