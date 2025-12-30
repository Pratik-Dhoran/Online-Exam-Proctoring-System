package com.exam.online_exam_system.result.service.impl;

import com.exam.online_exam_system.attempt.entity.Answer;
import com.exam.online_exam_system.attempt.entity.Attempt;
import com.exam.online_exam_system.attempt.repository.AnswerRepository;
import com.exam.online_exam_system.attempt.repository.AttemptRepository;
import com.exam.online_exam_system.common.exception.ApiException;
import com.exam.online_exam_system.result.entity.Result;
import com.exam.online_exam_system.result.repository.ResultRepository;
import com.exam.online_exam_system.result.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    AttemptRepository attemptRepository;
    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    ResultRepository resultRepository ;


    @Override
    public Result evaluateResult(Long attemptId) {

        Attempt attempt = attemptRepository.findById(attemptId)
                .orElseThrow(() -> new ApiException("Attempt not found"));

        List<Answer> answers = answerRepository.findAll()
                .stream()
                .filter(a -> a.getAttempt().getId().equals(attemptId))
                .toList();

        int correct = 0;

        for (Answer a : answers) {
            if (a.getSelectedOption().isCorrect()) {
                correct++;
            }
        }

        int total = answers.size();
        double percentage = total == 0 ? 0 : (correct * 100.0) / total;

        Result result = new Result();
        result.setAttempt(attempt);
        result.setScore(correct);
        result.setTotalQuestions(total);
        result.setPercentage(percentage);
        result.setPassed(percentage >= 40);

        return resultRepository.save(result);
    }
}
