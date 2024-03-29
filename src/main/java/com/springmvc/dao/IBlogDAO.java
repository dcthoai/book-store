package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Blog;

public interface IBlogDAO extends IGenericDAO<Blog>{
	public List<Blog> getTopBlog();
	public List<Blog> getAllBlogs();
}