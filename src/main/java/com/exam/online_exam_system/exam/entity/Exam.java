package com.exam.online_exam_system.exam.entity;

import com.exam.online_exam_system.question.entity.Question;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    private int durationMinutes;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private boolean paid;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Question> questions;


}
