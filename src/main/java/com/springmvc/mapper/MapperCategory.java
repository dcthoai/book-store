package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.Category;

public class MapperCategory implements RowMapper<Category>{

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category category = new Category();
		
		category.setId(rs.getInt("categoryID"));
		category.setCategoryName(rs.getString("categoryName"));
		category.setDescriptions(rs.getString("descriptions"));
		
		return category;
	}
}