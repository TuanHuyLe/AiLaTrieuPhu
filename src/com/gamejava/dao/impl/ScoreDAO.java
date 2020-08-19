package com.gamejava.dao.impl;

import com.gamejava.dao.IScoreDAO;
import com.gamejava.mapper.ScoreMapper;
import com.gamejava.model.Score;

import java.util.List;

public class ScoreDAO extends AbstractDAO<Score> implements IScoreDAO {
    @Override
    public List<Score> findAll() {
        String sql = "select * from score";
        return query(sql, new ScoreMapper());
    }

    @Override
    public Score findOne(int id) {
        String sql = "select * from score where id = ?";
        List<Score> list = query(sql, new ScoreMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Integer insert(Score score) {
        String sql = "insert into score(score,user_id) values(?,?)";
        return insert(sql, score.getScore(), score.getUserId());
    }

    @Override
    public void update(Score score) {
        String sql = "update score set score = ?, user_id = ? where id = ?";
        update(sql, score.getScore(), score.getUserId(), score.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from score where id = ?";
        update(sql, id);
    }
}
