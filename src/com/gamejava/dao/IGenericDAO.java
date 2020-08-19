package com.gamejava.dao;

import com.gamejava.mapper.IRowMapper;

import java.util.List;

public interface IGenericDAO<T> {
    <T> List<T> query(String sql, IRowMapper<T> rowMapper, Object... objects);

    void update(String sql, Object... objects);

    Integer insert(String sql, Object... objects);

}
