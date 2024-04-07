package com.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.dao.ICategoryDAO;
import com.springmvc.mapper.MapperCategory;
import com.springmvc.model.Category;

@Repository
public class CategoryDAO extends AbstractDAO<Category> implements ICategoryDAO{

	@Override
	public int insert(Category category) {
		String sql = "INSERT INTO `bookstore`.`category` (`name`, `description`, `createdBy`) VALUES (?, ?, ?)";
		
		int categoryId = executeInsert(sql, category.getName(), category.getDescription(), category.getCreatedBy());
		return categoryId;
	}

	@Override
	public int update(Category category) {
		String sql = "UPDATE `bookstore`.`category` SET `name` = ?, `description` = ?, `modifiedBy` = ? WHERE (`id` = ?)";
		
		int affectedRows = executeUpdate(sql, category.getName(), category.getDescription(), category.getModifiedBy(), category.getId());
		return affectedRows;
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM `bookstore`.`category` WHERE (`id` = ?)";
		
		int affectedRows = executeUpdate(sql, id);
		return affectedRows;
	}
	
	@Override
	public Category getById(int id) {
		String sql = "SELECT * FROM `bookstore`.`category` WHERE (`id` = ?)";
		List<Category> listCategories = executeQuery(sql, new MapperCategory(), id);
		
		return listCategories.isEmpty() ? null : listCategories.get(0);
	}
	
	@Override
	public List<Category> getAllCategories(){
		String sql = "SELECT * FROM `bookstore`.`category`";
		List<Category> listCategories = executeQuery(sql, new MapperCategory());
		
		return listCategories;
	}
}