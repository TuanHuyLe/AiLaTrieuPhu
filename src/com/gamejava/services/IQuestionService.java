package com.gamejava.services;

import com.gamejava.model.Question;

import java.util.List;

public interface IQuestionService {
    Question findOne(int id);

    List<Question> findAll();

    Question save(Question question);

    Question update(Question question);

    void delete(int[] ids);
}
