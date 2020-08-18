package com.gamejava.model;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    private List<String> answer;

    public Answer() {
        this.answer = new ArrayList<>();
    }

    public Answer(List<String> answer) {
        this.answer = answer;
    }

    public void addAnswer(String answer) {
        this.answer.add(answer);
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }
}
