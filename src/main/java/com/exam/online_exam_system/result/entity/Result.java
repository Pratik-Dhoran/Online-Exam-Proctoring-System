package com.exam.online_exam_system.result.entity;

import com.exam.online_exam_system.attempt.entity.Attempt;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Attempt attempt;

    private int score;
    private int totalQuestions;
    private double percentage;
    private boolean passed;

}
