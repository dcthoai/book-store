package com.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.dao.ISlideDAO;
import com.springmvc.mapper.MapperSlide;
import com.springmvc.model.Slide;

@Repository
public class SlideDAO extends AbstractDAO<Slide> implements ISlideDAO{
	
	@Override
	public int insert(Slide t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Slide t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Slide getById(int id) {
		String sql = "SELECT * FROM Slide WHERE slideID = ?";
		List<Slide> listSlides = excecuteQuery(sql, new MapperSlide(), id);
		
		return listSlides.isEmpty() ? null : listSlides.get(0);
	}
	
	@Override
	public Slide getFirstSlide() {
		String sql = "SELECT * FROM Slide LIMIT 1";
		List<Slide> listSlides = excecuteQuery(sql, new MapperSlide());
		
		return listSlides.isEmpty() ? null : listSlides.get(0);
	}

	@Override
	public List<Slide> getAllSlides() {
		String sql = "SELECT * FROM Slide ORDER BY createdDate DESC";
		List<Slide> listSlides = excecuteQuery(sql, new MapperSlide());
		
		return listSlides.isEmpty() ? null : listSlides;
	}
}