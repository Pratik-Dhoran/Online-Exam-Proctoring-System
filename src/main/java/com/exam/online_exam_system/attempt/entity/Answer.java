package com.exam.online_exam_system.attempt.entity;

import com.exam.online_exam_system.question.entity.Option;
import com.exam.online_exam_system.question.entity.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Attempt attempt;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Option selectedOption;

}
