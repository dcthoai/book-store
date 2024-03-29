package com.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.dao.ICategoryDAO;
import com.springmvc.mapper.MapperCategory;
import com.springmvc.model.Category;

@Repository
public class CategoryDAO extends AbstractDAO<Category> implements ICategoryDAO{

	@Override
	public int insert(Category t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Category t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Category getById(int id) {
		String sql = "SELECT * FROM Category WHERE ID = ?";
		List<Category> listCategories = excecuteQuery(sql, new MapperCategory(), id);
		
		return listCategories.isEmpty() ? null : listCategories.get(0);
	}
	
	@Override
	public List<Category> getAllCategories(){
		String sql = "SELECT * FROM Category";
		List<Category> listCategories = excecuteQuery(sql, new MapperCategory());
		
		return listCategories.isEmpty() ? null : listCategories;
	}
}