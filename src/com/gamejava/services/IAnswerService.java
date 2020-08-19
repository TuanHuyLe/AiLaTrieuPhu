package com.gamejava.services;

import com.gamejava.model.Answer;

import java.util.List;

public interface IAnswerService {
    Answer findOne(int id);

    List<Answer> findAll();

    Answer save(Answer answer);

    Answer update(Answer answer);

    void delete(int[] ids);
}
