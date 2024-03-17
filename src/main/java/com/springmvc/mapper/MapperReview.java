package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.Review;

public class MapperReview implements RowMapper<Review>{

	@Override
	public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
		Review review = new Review();
		
		review.setId(rs.getInt("reviewID"));
		review.setBookId(rs.getInt("bookID"));
		review.setCustomerId(rs.getInt("userID"));
		review.setStars(rs.getInt("stars"));
		review.setComment(rs.getString("comments"));
		
		return review;
	}
}