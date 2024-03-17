package com.springmvc.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.impl.CategoryDAO;
import com.springmvc.dao.impl.SlideDAO;
import com.springmvc.model.Category;
import com.springmvc.model.Slide;
import com.springmvc.service.user.IHomeService;

@Service
public class HomeService implements IHomeService{
	@Autowired
	private SlideDAO slideDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	public List<Slide> getAllSlides(){
		return slideDAO.getAllSlides();
	}
	
	@Override
	public List<Category> getAllCategories(){
		return categoryDAO.getAllCategories();
	}
}