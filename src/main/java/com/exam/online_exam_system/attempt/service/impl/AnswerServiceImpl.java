package com.exam.online_exam_system.attempt.service.impl;

import com.exam.online_exam_system.attempt.entity.Answer;
import com.exam.online_exam_system.attempt.entity.Attempt;
import com.exam.online_exam_system.attempt.repository.AnswerRepository;
import com.exam.online_exam_system.attempt.repository.AttemptRepository;
import com.exam.online_exam_system.attempt.service.AnswerService;
import com.exam.online_exam_system.common.exception.ApiException;
import com.exam.online_exam_system.question.entity.Option;
import com.exam.online_exam_system.question.entity.Question;
import com.exam.online_exam_system.question.repository.OptionRepository;
import com.exam.online_exam_system.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    AttemptRepository attemptRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    OptionRepository optionRepository;


    @Override
    public void submitAnswer(Long attemptId, Long questionId, Long optionId) {

        Attempt attempt = attemptRepository.findById(attemptId)
                .orElseThrow(() -> new ApiException("Attempt not found"));

        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new ApiException("Question not found"));

        Option option = optionRepository.findById(optionId)
                .orElseThrow(() -> new ApiException("Option not found"));

        Answer answer = new Answer();
        answer.setAttempt(attempt);
        answer.setQuestion(question);
        answer.setSelectedOption(option);

        answerRepository.save(answer);
    }
}
