package com.exam.online_exam_system.exam.service;

import com.exam.online_exam_system.common.dto.AddQuestionRequest;
import com.exam.online_exam_system.common.dto.ExamPaperResponse;
import com.exam.online_exam_system.exam.entity.Exam;

import java.util.List;

public interface ExamService {
    Exam createExam(Exam exam);

    ExamPaperResponse getExamPaper(Long examId);

    List<Exam> getAllExams();

    Exam addQuestion(Long examId, AddQuestionRequest request);

}
