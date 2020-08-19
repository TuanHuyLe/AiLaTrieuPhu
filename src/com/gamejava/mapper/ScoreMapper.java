package com.gamejava.mapper;

import com.gamejava.model.Score;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreMapper implements IRowMapper<Score> {
    @Override
    public Score mapRow(ResultSet resultSet) {
        Score score = new Score();
        try {
            score.setId(resultSet.getInt("id"));
            score.setScore(resultSet.getInt("score"));
            score.setUserId(resultSet.getInt("user_id"));
            return score;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
