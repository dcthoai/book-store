package com.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.dao.IMediaDAO;
import com.springmvc.mapper.MapperMedia;
import com.springmvc.model.Media;

@Repository
public class MediaDAO extends AbstractDAO<Media> implements IMediaDAO{

	@Override
	public int insert(Media media) {
		String sql = "INSERT INTO `bookstore`.`media` (`name`, `path`, `type`, `size`, `createdBy`)"
						+ " VALUES (?, ?, ?, ?, ?)";
		
		int mediaId = executeInsert(sql, media.getName(),
										 media.getPath(),
										 media.getType(),
										 media.getSize(),
										 media.getCreatedBy());
										 
		return mediaId;
	}

	@Override
	public int update(Media media) {
		String sql = "UPDATE `bookstore`.`media` "
						+ "SET `name` = ?, `path` = ?, `type` = ?, `size` = ?, `modifiedBy` = ? WHERE (`id` = ?)";
		
		int effectedRows = executeUpdate(sql, media.getName(),
											  media.getPath(),
											  media.getType(),
											  media.getSize(),
											  media.getModifiedBy(),
											  media.getId());
		
		return effectedRows;
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM `bookstore`.`media` WHERE (`id` = ?)";
		
		int affectedRows = executeUpdate(sql, id);
		return affectedRows;
	}
	
	@Override
	public Media getById(int id) {
		String sql = "SELECT * FROM `bookstore`.`media` WHERE (`id` = ?)";
		List<Media> listMedias = executeQuery(sql, new MapperMedia(), id);
		
		return listMedias.isEmpty() ? null : listMedias.get(0);
	}

	@Override
	public List<Media> getBookMedias(int bookId) {
		String sql = "SELECT * FROM `bookstore`.`media` as m "
						+ "JOIN `bookstore`.`bookMedia` bm ON m.id = bm.mediaId "
						+ "JOIN `bookstore`.`book` b ON b.id = bm.bookId "
						+ "WHERE b.id = ?";
		
		List<Media> listMedias = executeQuery(sql, new MapperMedia(), bookId);
		return listMedias;
	}
}