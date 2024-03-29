package com.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.dao.IMediaDAO;
import com.springmvc.mapper.MapperMedia;
import com.springmvc.model.Media;

@Repository
public class MediaDAO extends AbstractDAO<Media> implements IMediaDAO{

	@Override
	public int insert(Media t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Media t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Media getById(int id) {
		String sql = "SELECT * FROM Media WHERE mediaID = ?";
		List<Media> listMedias = excecuteQuery(sql, new MapperMedia(), id);
		
		return listMedias.isEmpty() ? null : listMedias.get(0);
	}

	@Override
	public List<Media> getBookMedias(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Media> getBlogMedias(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}
}