package com.exam.online_exam_system.proctoring.entity;

import com.exam.online_exam_system.attempt.entity.Attempt;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "proctor_logs")
public class ProctorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Attempt attempt;

    private String eventType;
    private LocalDateTime eventTime;
    private String details;

}
