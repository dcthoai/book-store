package com.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.dao.ISlideDAO;
import com.springmvc.mapper.MapperSlide;
import com.springmvc.model.Slide;

@Repository
public class SlideDAO extends AbstractDAO<Slide> implements ISlideDAO{
	
	@Override
	public int insert(Slide slide) {
		String sql = "INSERT INTO `bookstore`.`slide`" 
						+ "(`slideMedia`, `caption`, `content`, `createdBy`, `slideLink`)"
						+ "VALUES (?, ?, ?, ?, ?)";
		
		int slideId = executeInsert(sql, slide.getSlideMedia(), 
												slide.getCaption(), 
												slide.getContent(), 
												slide.getCreatedBy(), 
												slide.getSlideLink());
		return slideId;
	}

	@Override
	public int update(Slide slide) {
		String sql = "UPDATE `bookstore`.`slide` SET"
						+ "`slideMedia` = '2', "
						+ "`caption` = ?, "
						+ "`content` = ?, "
						+ "`modifiedBy` = ?, "
						+ "`slideLink` = ? WHERE (`slideId` = '4')";
		
		int affectedRows = executeInsert(sql, slide.getSlideMedia(), 
												slide.getCaption(), 
												slide.getContent(), 
												slide.getModifiedBy(), 
												slide.getSlideLink());
		return affectedRows;
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM `bookstore`.`slide` WHERE (`slideId` = ?)";
		
		int affectedRows = executeUpdate(sql, id);
		return affectedRows;
	}
	
	@Override
	public Slide getById(int id) {
		String sql = "SELECT * FROM `bookstore`.`slide` WHERE (`slideId` = ?)";
		List<Slide> listSlides = executeQuery(sql, new MapperSlide(), id);
		
		return listSlides.isEmpty() ? null : listSlides.get(0);
	}
	
	@Override
	public Slide getFirstSlide() {
		String sql = "SELECT * FROM `bookstore`.`slide` LIMIT 1";
		List<Slide> listSlides = executeQuery(sql, new MapperSlide());
		
		return listSlides.isEmpty() ? null : listSlides.get(0);
	}

	@Override
	public List<Slide> getAllSlides() {
		String sql = "SELECT * FROM `bookstore`.`slide` ORDER BY `createdDate` DESC";
		List<Slide> listSlides = executeQuery(sql, new MapperSlide());
		
		return listSlides;
	}
}