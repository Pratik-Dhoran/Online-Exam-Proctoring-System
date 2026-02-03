package com.exam.online_exam_system.exam.service.impl;

import com.exam.online_exam_system.common.dto.AddQuestionRequest;
import com.exam.online_exam_system.common.dto.ExamPaperResponse;
import com.exam.online_exam_system.common.exception.ApiException;
import com.exam.online_exam_system.exam.entity.Exam;
import com.exam.online_exam_system.exam.repository.ExamRepository;
import com.exam.online_exam_system.exam.service.ExamService;
import com.exam.online_exam_system.question.entity.Option;
import com.exam.online_exam_system.question.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
     ExamRepository examRepository;

    @Override
    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public ExamPaperResponse getExamPaper(Long examId) {

        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new ApiException("Exam not found"));

        ExamPaperResponse response = new ExamPaperResponse();
        response.setExamId(exam.getId());
        response.setTitle(exam.getTitle());
        response.setDurationMinutes(exam.getDurationMinutes());

        List<ExamPaperResponse.QuestionResponse> questions =
                exam.getQuestions().stream().map(q -> {

                    ExamPaperResponse.QuestionResponse qr = new ExamPaperResponse.QuestionResponse();
                    qr.setQuestionId(q.getId());
                    qr.setText(q.getText());

                    List<ExamPaperResponse.OptionResponse> options =
                            q.getOptions().stream().map(o -> {
                                ExamPaperResponse.OptionResponse or = new ExamPaperResponse.OptionResponse();
                                or.setOptionId(o.getId());
                                or.setText(o.getText());
                                return or;
                            }).toList();

                    qr.setOptions(options);
                    return qr;

                }).toList();

        response.setQuestions(questions);
        return response;
    }

    @Override
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    @Override
    public Exam addQuestion(Long examId, AddQuestionRequest request) {

        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new ApiException("Exam not found"));

        Question q = new Question();
        q.setText(request.getText());
        q.setExam(exam);

        List<Option> optionList = new ArrayList<>();

        for (int i = 0; i < request.getOptions().size(); i++) {

            Option opt = new Option();
            opt.setText(request.getOptions().get(i));
            opt.setCorrect(i == request.getCorrectOptionIndex());
            opt.setQuestion(q);

            optionList.add(opt);
        }

        q.setOptions(optionList);
        exam.getQuestions().add(q);

        return examRepository.save(exam);
    }


}
