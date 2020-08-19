package com.gamejava.model;

public class Score {
    private int id;
    private Integer score;
    private Integer userId;

    public Score() {
    }

    public Score(int id, Integer score, Integer userId) {
        this.id = id;
        this.score = score;
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
