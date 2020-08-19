package com.gamejava.services;

import com.gamejava.model.Score;

import java.util.List;

public interface IScoreService {
    Score findOne(int id);

    List<Score> findAll();

    Score save(Score score);

    Score update(Score score);

    void delete(int[] ids);
}
