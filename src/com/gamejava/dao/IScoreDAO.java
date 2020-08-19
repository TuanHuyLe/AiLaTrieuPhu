package com.gamejava.dao;

import com.gamejava.model.Score;

import java.util.List;

public interface IScoreDAO extends IGenericDAO<Score> {
    List<Score> findAll();

    Score findOne(int id);

    Integer insert(Score score);

    void update(Score score);

    void delete(int id);
}
