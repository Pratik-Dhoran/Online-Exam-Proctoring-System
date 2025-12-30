package com.exam.online_exam_system.question.entity;

import com.exam.online_exam_system.exam.entity.Exam;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    @JsonBackReference
    private Exam exam;

    @Column(length = 2000)
    private String text;

    private String topic;
    private String difficulty;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Option> options;


}
