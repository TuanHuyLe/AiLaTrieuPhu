package com.gamejava.services.impl;

import com.gamejava.dao.IScoreDAO;
import com.gamejava.model.Score;
import com.gamejava.services.IScoreService;

import java.util.List;

public class ScoreService implements IScoreService {

    private IScoreDAO scoreDAO;

    public ScoreService(IScoreDAO scoreDAO) {
        this.scoreDAO = scoreDAO;
    }

    @Override
    public Score findOne(int id) {
        return scoreDAO.findOne(id);
    }

    @Override
    public List<Score> findAll() {
        return scoreDAO.findAll();
    }

    @Override
    public Score save(Score score) {
        Integer scoreID = scoreDAO.insert(score);
        return scoreDAO.findOne(scoreID);
    }

    @Override
    public Score update(Score score) {
        scoreDAO.update(score);
        return scoreDAO.findOne(score.getId());
    }

    @Override
    public void delete(int[] ids) {
        for (int id : ids) {
            scoreDAO.delete(id);
        }
    }
}
