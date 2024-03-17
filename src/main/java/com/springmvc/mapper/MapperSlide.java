package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.Slide;

public class MapperSlide implements RowMapper<Slide>{

	@Override
	public Slide mapRow(ResultSet rs, int rowNum) throws SQLException {
		Slide slide = new Slide();
		
		slide.setId(rs.getInt("slideID"));
		slide.setSlideMedia(rs.getInt("slideMedia"));
		slide.setCaption(rs.getString("caption"));
		slide.setContent(rs.getString("content"));
		
		return slide;
	}
}