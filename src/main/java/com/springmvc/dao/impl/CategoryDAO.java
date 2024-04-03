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
		String sql = "INSERT INTO `bookstore`.`category` (`categoryName`, `descriptions`, `createdBy`) VALUES (?, ?, ?)";
		
		int categoryId = executeInsert(sql, category.getCategoryName(), category.getDescriptions(), category.getCreatedBy());
		return categoryId;
	}

	@Override
	public int update(Category category) {
		String sql = "UPDATE `bookstore`.`category` SET `categoryName` = ?, `descriptions` = ?, `modifiedBy` = ? WHERE (`categoryId` = ?)";
		
		int affectedRows = executeUpdate(sql, category.getCategoryName(), category.getDescriptions(), category.getModifiedBy());
		return affectedRows;
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM `bookstore`.`category` WHERE (`categoryId` = ?)";
		
		int affectedRows = executeUpdate(sql, id);
		return affectedRows;
	}
	
	@Override
	public Category getById(int id) {
		String sql = "SELECT * FROM `bookstore`.`category` WHERE (`categoryId` = ?)";
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