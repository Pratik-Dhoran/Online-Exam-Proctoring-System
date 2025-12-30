package com.exam.online_exam_system.exam.service;

import com.exam.online_exam_system.common.dto.ExamPaperResponse;
import com.exam.online_exam_system.exam.entity.Exam;

public interface ExamService {
    Exam createExam(Exam exam);

    ExamPaperResponse getExamPaper(Long examId);
}
