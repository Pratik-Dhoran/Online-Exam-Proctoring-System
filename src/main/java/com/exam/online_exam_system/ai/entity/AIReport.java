package com.exam.online_exam_system.ai.entity;

import com.exam.online_exam_system.attempt.entity.Attempt;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AIReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;

    @OneToOne
    Attempt attempt ;

    int riskScore ;

    String riskLevel ;

    String summary ;
}
