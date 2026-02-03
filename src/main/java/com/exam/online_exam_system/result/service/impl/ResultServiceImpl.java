package com.exam.online_exam_system.result.service.impl;

import com.exam.online_exam_system.attempt.entity.Answer;
import com.exam.online_exam_system.attempt.entity.Attempt;
import com.exam.online_exam_system.attempt.repository.AnswerRepository;
import com.exam.online_exam_system.attempt.repository.AttemptRepository;
import com.exam.online_exam_system.common.dto.ResultResponse;
import com.exam.online_exam_system.common.exception.ApiException;
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

    @Override
    public ResultResponse calculateResult(Long attemptId) {

        Attempt attempt = attemptRepository.findById(attemptId)
                .orElseThrow(() -> new ApiException("Attempt not found"));

        List<Answer> answers = answerRepository.findByAttemptId(attemptId);

        int total = attempt.getExam().getQuestions().size();
        int score = 0;

        for (Answer answer : answers) {
            if (answer.getSelectedOption().isCorrect()) {
                score++;
            }
        }

        int riskScore = attempt.getRiskScore();

        double percentage = (score * 100.0) / total;

        String status = percentage >= 50 ? "PASS" : "FAIL";

        String feedback;

        if (answers.isEmpty()) {
            feedback = "You did not attempt any questions. Please try to answer before submitting.";
        }
        else if (percentage == 100 && riskScore == 0) {
            feedback = "Outstanding performance with perfect discipline.";
        }
        else if (percentage >= 75 && riskScore < 20) {
            feedback = "Very good performance with minimal suspicious activity.";
        }
        else if (percentage >= 50 && riskScore < 20) {
            feedback = "Good performance. You maintained decent discipline.";
        }
        else if (percentage >= 50 && riskScore >= 20) {
            feedback = "Good score, but multiple suspicious activities were detected.";
        }
        else if (percentage < 50 && riskScore < 20) {
            feedback = "You need improvement. Focus more on preparation.";
        }
        else {
            feedback = "Low performance with high suspicious activity detected during exam.";
        }


        ResultResponse response = new ResultResponse();
        response.setScore(score);
        response.setTotal(total);
        response.setStatus(status);
        response.setRiskScore(riskScore);
        response.setFeedback(feedback);

        return response;
    }
}
