package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.Review;

public class MapperReview implements RowMapper<Review>{

	@Override
	public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
		Review review = new Review();
		
		review.setId(rs.getInt("id"));
		
        review.setBookId(rs.getInt("bookId"));
        review.setCustomerId(rs.getInt("customerId"));
        review.setStars(rs.getInt("stars"));
        review.setComment(rs.getString("comment"));
        
        review.setCreatedDate(rs.getTimestamp("createdDate"));
        review.setModifiedDate(rs.getTimestamp("modifiedDate"));
        review.setCreatedBy(rs.getString("createdBy"));
        review.setModifiedBy(rs.getString("modifiedBy"));
		
		return review;
	}
}