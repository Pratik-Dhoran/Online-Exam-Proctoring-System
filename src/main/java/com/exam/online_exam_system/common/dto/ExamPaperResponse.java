package com.exam.online_exam_system.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ExamPaperResponse {


     private Long examId ;
     private String title ;
     private int durationMinutes ;
     private List< QuestionResponse > questions ;

     @Getter
     @Setter
     public static  class QuestionResponse {

          private Long questionId ;
          private String text ;
          private List<OptionResponse> options ;
     }

     @Getter
     @Setter
     public static class OptionResponse{

        private Long optionId ;
        private String text ;
     }
}
