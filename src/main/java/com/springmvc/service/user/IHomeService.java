package com.springmvc.service.user;

import java.util.List;

import com.springmvc.model.Blog;
import com.springmvc.model.Slide;

public interface IHomeService {
	public List<Slide> getAllSlides();
	public List<Blog> getNewBlogs();
}