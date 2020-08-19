package com.gamejava.dao.impl;

import com.gamejava.dao.IQuestionDAO;
import com.gamejava.mapper.QuestionMapper;
import com.gamejava.model.Question;

import java.util.List;

public class QuestionDAO extends AbstractDAO<Question> implements IQuestionDAO {

    @Override
    public List<Question> findAll() {
        String sql = "select * from questions";
        return query(sql, new QuestionMapper());
    }

    @Override
    public Question findOne(int id) {
        String sql = "select * from questions where id = ?";
        List<Question> questionList = query(sql, new QuestionMapper(), id);
        return questionList.isEmpty() ? null : questionList.get(0);
    }

    @Override
    public Integer save(Question question) {
        String sql = "insert into questions values(?,?)";
        return insert(sql, question.getQuestion(), question.getCorrectAnswer());
    }

    @Override
    public void update(Question question) {
        String sql = "update questions set question = ?, correct_answer = ? where id = ?";
        update(sql, question.getQuestion(), question.getCorrectAnswer(), question.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from questions where id = ?";
        update(sql, id);
    }
}
