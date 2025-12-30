package com.exam.online_exam_system.question.service.impl;

import com.exam.online_exam_system.question.entity.Question;
import com.exam.online_exam_system.question.repository.QuestionRepository;
import com.exam.online_exam_system.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository ;

    @Override
    public Question addQuestion(Question question)
    {
        return questionRepository.save(question) ;
    }
}
