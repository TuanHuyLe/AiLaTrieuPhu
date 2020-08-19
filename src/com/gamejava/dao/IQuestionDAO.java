package com.gamejava.dao;

import com.gamejava.model.Question;

import java.util.List;

public interface IQuestionDAO extends IGenericDAO<Question> {
    List<Question> findAll();

    Question findOne(int id);

    Integer save(Question question);

    void update(Question question);

    void delete(int id);
}
