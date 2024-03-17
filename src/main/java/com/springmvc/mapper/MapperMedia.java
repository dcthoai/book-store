package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.Media;

public class MapperMedia implements RowMapper<Media>{

	@Override
	public Media mapRow(ResultSet rs, int rowNum) throws SQLException {
		Media media = new Media();
		
		media.setId(rs.getInt("mediaID"));
		media.setMediaName(rs.getString("mediaName"));
		media.setMediaPath(rs.getString("mediaPath"));
		media.setMediaType(rs.getString("mediaType"));
		media.setMediaSize(rs.getInt("mediaSize"));
		
		return media;
	}
}