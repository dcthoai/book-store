package com.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.dao.ISlideDAO;
import com.springmvc.mapper.MapperSlide;
import com.springmvc.model.Slide;

@Repository
public class SlideDAO extends AbstractDAO<Slide> implements ISlideDAO{
	@Override
	public List<Slide> getAllSlides(){ 
		String sql = "SELECT * FROM Slide";
		List<Slide> listSlides = query(sql, new MapperSlide()); 
		return listSlides;
	}

	@Override
	public Slide getFirstSlide() {
		String sql = "SELECT * FROM Slide Where id = ?";
		List<Slide> listSlides = query(sql, new MapperSlide(), 1);
		return listSlides.isEmpty() ? null : listSlides.get(0);
	}
}