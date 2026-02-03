package com.exam.online_exam_system.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultResponse {

    private int score;
    private int total;
    private String status;
    private int riskScore;
    private String feedback;
}
