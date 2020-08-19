package com.gamejava.services.impl;

import com.gamejava.dao.IQuestionDAO;
import com.gamejava.model.Question;
import com.gamejava.services.IQuestionService;

import java.util.List;

public class QuestionService implements IQuestionService {

    private IQuestionDAO questionDAO;

    public QuestionService(IQuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    @Override
    public Question findOne(int id) {
        return questionDAO.findOne(id);
    }

    @Override
    public List<Question> findAll() {
        return questionDAO.findAll();
    }

    @Override
    public Question save(Question question) {
        Integer questionId = questionDAO.save(question);
        return questionDAO.findOne(questionId);
    }

    @Override
    public Question update(Question question) {
        questionDAO.update(question);
        return questionDAO.findOne(question.getId());
    }

    @Override
    public void delete(int[] ids) {
        for (int id : ids) {
            questionDAO.delete(id);
        }
    }
}
