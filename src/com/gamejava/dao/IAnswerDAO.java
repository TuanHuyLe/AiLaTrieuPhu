package com.gamejava.dao;

import com.gamejava.model.Answer;

import java.util.List;

public interface IAnswerDAO extends IGenericDAO<Answer> {
    Answer findOne(int id);

    List<Answer> findAll();

    Integer save(Answer answer);

    void update(Answer answer);

    void delete(int id);
}
