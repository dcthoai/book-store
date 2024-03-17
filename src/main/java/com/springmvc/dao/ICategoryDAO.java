package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Category;

public interface ICategoryDAO extends IGenericDAO<Category>{
	List<Category> getAllCategories();
	Category getCategoryById(int id);
}