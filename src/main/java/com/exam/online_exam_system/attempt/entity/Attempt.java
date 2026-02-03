package com.exam.online_exam_system.attempt.entity;

import com.exam.online_exam_system.exam.entity.Exam;
import com.exam.online_exam_system.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "attempts")
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Exam exam;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private String status; // IN_PROGRESS, SUBMITTED, TIMEOUT

    private int riskScore = 0;

}
