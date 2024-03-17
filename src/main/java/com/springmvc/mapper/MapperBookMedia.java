package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.BookMedia;

public class MapperBookMedia implements RowMapper<BookMedia>{

	@Override
	public BookMedia mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookMedia productMedia = new BookMedia();
		
		productMedia.setMediaId(rs.getInt("mediaID"));
		productMedia.setBookId(rs.getInt("bookID"));
		
		return productMedia;
	}
}