package com.gamejava.mapper;

import com.gamejava.model.Answer;

import java.sql.ResultSet;

public class AnswerMapper implements IRowMapper<Answer> {
    @Override
    public Answer mapRow(ResultSet resultSet) {
        Answer answer = new Answer();
        try {
            answer.setId(resultSet.getInt("id"));
            answer.setAnswer(resultSet.getString("answer"));
            answer.setQuestionId(resultSet.getInt("question_id"));
            return answer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
