package com.exam.online_exam_system.question.controller;


import com.exam.online_exam_system.question.entity.Question;
import com.exam.online_exam_system.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService ;

    @PostMapping
    public Question addQuestion(@RequestBody Question question)
    {
       return questionService.addQuestion(question) ;
    }
}
