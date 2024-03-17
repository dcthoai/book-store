package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.ReviewMedia;

public class MapperReviewMedia implements RowMapper<ReviewMedia>{

	@Override
	public ReviewMedia mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReviewMedia reviewMedia = new ReviewMedia();
		
		reviewMedia.setReviewId(rs.getInt("reviewID"));
		reviewMedia.setMediaId(rs.getInt("mediaID"));
		
		return reviewMedia;
	}
}