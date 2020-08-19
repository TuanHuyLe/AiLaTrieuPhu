package com.gamejava.dao.impl;

import com.gamejava.dao.IAnswerDAO;
import com.gamejava.mapper.AnswerMapper;
import com.gamejava.model.Answer;

import java.util.List;

public class AnswerDAO extends AbstractDAO<Answer> implements IAnswerDAO {
    @Override
    public Answer findOne(int id) {
        String sql = "select * from answers where id = ?";
        List<Answer> list = query(sql, new AnswerMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<Answer> findAll() {
        String sql = "select * from answers";
        return query(sql, new AnswerMapper());
    }

    @Override
    public Integer save(Answer answer) {
        String sql = "insert into answers values(?,?)";
        return insert(sql, answer.getAnswer(), answer.getQuestionId());
    }

    @Override
    public void update(Answer answer) {
        String sql = "update answers set answer = ?, question_id = ? where id = ?";
        update(sql, answer.getAnswer(), answer.getQuestionId(), answer.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from answers where id = ?";
        update(sql, id);
    }
}
