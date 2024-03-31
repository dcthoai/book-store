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
public class AbstractDAO<T>{
	@Autowired 
	public JdbcTemplate _jdbcTemplate;
	
	public List<T> excecuteQuery(String sql, RowMapper<T> rowMapper, Object... parameters){
		try {
			List<T> listItems = _jdbcTemplate.query(sql, parameters, rowMapper);
			
			return listItems;
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList(); // Return empty list if has exception
		}
	}

	public int excecuteInsert(String sql, Object... parameters) {
		try {
			int affectedRows = _jdbcTemplate.update(sql, parameters);
			
			// If number of lines changed in the database more than 0
//			if (affectedRows > 0) {
//				int idObject = _jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
//				return idObject;	// Return id of item was added
//			}
            
            return affectedRows;
        } catch (DataAccessException e) {
        	e.printStackTrace();
            return 0;
        }
	}
	
	public boolean executeUpdate(String sql, Object... parameters) {
		try {
            _jdbcTemplate.update(sql, parameters);
            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
	}
}