package com.springmvc.service.user;

import java.util.List;

import com.springmvc.model.Category;
import com.springmvc.model.Slide;

public interface IHomeService {
	public List<Slide> getAllSlides();
	public List<Category> getAllCategories();
}
