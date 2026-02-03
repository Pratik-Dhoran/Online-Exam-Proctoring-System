package com.exam.online_exam_system.common.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AIRiskReport {

    private String riskLevel;   // LOW / MEDIUM / HIGH
    private String summary;

}
