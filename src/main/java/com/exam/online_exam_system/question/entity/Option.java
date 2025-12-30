package com.exam.online_exam_system.question.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id ;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonBackReference
    private  Question question ;

    @Column ( length = 1000)
    private String text ;

    private boolean correct ;
}
