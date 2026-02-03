package com.exam.online_exam_system.common.dto;

import java.util.List;

public class AddQuestionRequest {

    private String text;
    private List<String> options;
    private int correctOptionIndex;

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public List<String> getOptions() { return options; }
    public void setOptions(List<String> options) { this.options = options; }

    public int getCorrectOptionIndex() { return correctOptionIndex; }
    public void setCorrectOptionIndex(int correctOptionIndex) {
        this.correctOptionIndex = correctOptionIndex;
    }
}
