package com.gamejava.mapper;

import com.gamejava.model.Question;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements IRowMapper<Question> {
    @Override
    public Question mapRow(ResultSet resultSet) {
        Question question = new Question();
        try {
            question.setId(resultSet.getInt("id"));
            question.setQuestion(resultSet.getString("question"));
            question.setCorrectAnswer(resultSet.getString("correct_answer"));
            return question;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
