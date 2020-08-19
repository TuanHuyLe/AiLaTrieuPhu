package com.gamejava.model;

public class Answer {
    private Integer Id;
    private String answer;
    private Integer questionId;

    public Answer() {
    }

    public Answer(Integer id, String answer, Integer questionId) {
        Id = id;
        this.answer = answer;
        this.questionId = questionId;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}
