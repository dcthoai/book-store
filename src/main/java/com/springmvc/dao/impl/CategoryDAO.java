package com.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.dao.ICategoryDAO;
import com.springmvc.mapper.MapperCategory;
import com.springmvc.model.Category;

@Repository
public class CategoryDAO extends AbstractDAO<Category> implements ICategoryDAO{
	
	@Override
	public List<Category> getAllCategories(){
		String sql = "SELECT * FROM Category";
		List<Category> listCategories = query(sql, new MapperCategory());
		return listCategories;
	}

	@Override
	public Category getCategoryById(int id) {
		String sql = "SELECT * FROM Category WHERE ID = ?";
		List<Category> listCategories = query(sql, new MapperCategory(), id);
		return listCategories.isEmpty() ? null : listCategories.get(0);
	}
}