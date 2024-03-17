package com.springmvc.dao.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springmvc.dao.IGenericDAO;

@Repository
public class AbstractDAO<T> implements IGenericDAO<T>{
	@Autowired 
	public JdbcTemplate _jdbcTemplate;

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		try {
            return _jdbcTemplate.query(sql, parameters, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList(); // Return empty list if has exception
        }
	}
		
//	Older JDBC method
//  public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
//		Connection connection = null;
//		PreparedStatement statement = null;
//		ResultSet resultSet = null;
//		List<T> results = new ArrayList<>();
//		try {
//			connection = getConnection();
//			statement = connection.prepareStatement(sql);
//			setParameter(statement, parameters);
//			resultSet = statement.executeQuery();
//			while (resultSet.next()) {
//				results.add(rowMapper.mapRow(resultSet));
//			}
//			return results;
//		} catch (SQLException e) {
//			return null;
//		} finally {
//			try {
//				if (connection != null) {
//					connection.close();
//				}
//				if (statement != null) {
//					statement.close();
//				}
//				if (resultSet != null) {
//					resultSet.close();
//				}
//			} catch (SQLException e) {
//				return null;
//			}
//		}
//	}

	@Override
	public void update(String sql, Object... parameters) {
		try {
            _jdbcTemplate.update(sql, parameters);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		try {
            _jdbcTemplate.update(sql, parameters);
            
            return _jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class); // Return id of item was added
        } catch (DataAccessException e) {
        	e.printStackTrace();
            return null;
        }
	}

	@Override
	public int count(String sql, Object... parameters) {
		try {
            return _jdbcTemplate.queryForObject(sql, Integer.class, parameters);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return 0;
        }
	}
}