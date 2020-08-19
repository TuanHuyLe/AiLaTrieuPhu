package com.gamejava.services.impl;

import com.gamejava.dao.IAnswerDAO;
import com.gamejava.model.Answer;
import com.gamejava.services.IAnswerService;

import java.util.List;

public class AnswerService implements IAnswerService {
    private IAnswerDAO answerDAO;

    public AnswerService(IAnswerDAO answerDAO) {
        this.answerDAO = answerDAO;
    }

    @Override
    public Answer findOne(int id) {
        return answerDAO.findOne(id);
    }

    @Override
    public List<Answer> findAll() {
        return answerDAO.findAll();
    }

    @Override
    public Answer save(Answer answer) {
        Integer answerId = answerDAO.save(answer);
        return answerDAO.findOne(answerId);
    }

    @Override
    public Answer update(Answer answer) {
        answerDAO.update(answer);
        return answerDAO.findOne(answer.getId());
    }

    @Override
    public void delete(int[] ids) {
        for (int id : ids) {
            answerDAO.delete(id);
        }
    }
}
