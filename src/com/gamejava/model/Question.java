package com.gamejava.model;

public class Question {
    private Integer id;
    private String question;
    private String correctAnswer;

    public Question() {
    }

    public Question(Integer id, String question, String correctAnswer) {
        this.id = id;
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
