package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.BookMedia;

public class MapperBookMedia implements RowMapper<BookMedia>{

	@Override
	public BookMedia mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookMedia bookMedia = new BookMedia();
		
		bookMedia.setId(rs.getInt("bookMediaID"));
		bookMedia.setMediaId(rs.getInt("mediaID"));
		bookMedia.setBookId(rs.getInt("bookID"));
		bookMedia.setCreatedDate(rs.getTimestamp("createdDate"));
		bookMedia.setModifiedDate(rs.getTimestamp("modifiedDate"));
		bookMedia.setCreatedBy(rs.getString("createdBy"));
		bookMedia.setModifiedBy(rs.getString("modifiedBy"));
		
		return bookMedia;
	}
}