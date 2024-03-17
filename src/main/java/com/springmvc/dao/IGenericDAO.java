package com.springmvc.dao;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public interface IGenericDAO<T> {
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
	void update (String sql, Object... parameters);
	Long insert (String sql, Object... parameters);
	int count(String sql, Object... parameters);
}