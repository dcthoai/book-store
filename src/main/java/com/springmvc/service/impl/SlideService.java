package com.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.impl.SlideDAO;
import com.springmvc.model.Slide;
import com.springmvc.service.ISlideService;

@Service
public class SlideService implements ISlideService{

	@Autowired
	private SlideDAO slideDAO;
	
	@Override
	public List<Slide> getAllSlides() {
		return slideDAO.getAllSlides();
	}

}
