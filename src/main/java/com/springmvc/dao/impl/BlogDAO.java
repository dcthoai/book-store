package com.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.dao.IBlogDAO;
import com.springmvc.mapper.MapperBlog;
import com.springmvc.model.Blog;

@Repository
public class BlogDAO extends AbstractDAO<Blog> implements IBlogDAO{
	
	@Override
	public int insert(Blog t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Blog t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Blog getById(int id) {
		String sql = "SELECT * FROM Blog WHERE blogID = ?";
		
		List<Blog> listBlogs = excecuteQuery(sql, new MapperBlog(), id);
		return listBlogs.isEmpty() ? null : listBlogs.get(0);
	}
	
	@Override
	public List<Blog> getTopBlog() {
		// returns the 3 newest blogs
		String sql = "SELECT * FROM Blog ORDER BY createdDate DESC LIMIT 3";
		
		List<Blog> listBlogs = excecuteQuery(sql, new MapperBlog());
		return listBlogs.isEmpty() ? null : listBlogs;
	}

	@Override
	public List<Blog> getAllBlogs() {
		String sql = "SELECT * FROM Blog";
		
		List<Blog> listBlogs = excecuteQuery(sql, new MapperBlog()); 
		return listBlogs.isEmpty() ? null : listBlogs;
	}
}