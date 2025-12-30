package com.exam.online_exam_system.exam.controller;

import com.exam.online_exam_system.common.dto.ExamPaperResponse;
import com.exam.online_exam_system.exam.entity.Exam;
import com.exam.online_exam_system.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    @Autowired
    ExamService examService;

    @PostMapping
    public Exam createExam(@RequestBody Exam exam) {
        return examService.createExam(exam);
    }

    @GetMapping("/{examId}/paper")
    public ExamPaperResponse getExamPaper(@PathVariable Long examId)
    {
        return examService.getExamPaper(examId) ;
    }
}
