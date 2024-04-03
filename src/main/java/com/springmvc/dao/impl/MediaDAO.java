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
		String sql = "INSERT INTO `bookstore`.`media` (`mediaName`, `mediaPath`, `mediaType`, `mediaSize`, `createdBy`) "
						+ "VALUES (?, ?, ?, ?, ?)";
		int mediaId = executeInsert(sql, media.getMediaName(), 
											media.getMediaPath(), 
											media.getMediaType(), 
											media.getMediaSize(), 
											media.getCreatedBy());
		return mediaId;
	}

	@Override
	public int update(Media media) {
		String sql = "UPDATE `bookstore`.`media` SET "
						+ "`mediaName` = ?, "
						+ "`mediaPath` = ?, "
						+ "`mediaType` = ?, "
						+ "`mediaSize` = ?, "
						+ "`modifiedBy` = ? WHERE (`mediaID` = ?)";
		int effectedRows = executeUpdate(sql, media.getMediaName(),
												media.getMediaPath(),
												media.getMediaType(),
												media.getMediaSize(),
												media.getModifiedBy());
		return effectedRows;
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM `bookstore`.`media` WHERE (`mediaID` = ?)";
		
		int affectedRows = executeUpdate(sql, id);
		return affectedRows;
	}
	
	@Override
	public Media getById(int id) {
		String sql = "SELECT * FROM `bookstore`.`media` WHERE (`mediaID` = ?)";
		List<Media> listMedias = executeQuery(sql, new MapperMedia(), id);
		
		return listMedias.isEmpty() ? null : listMedias.get(0);
	}

	@Override
	public List<Media> getBookMedias(int bookId) {
		String sql = "SELECT * FROM `bookstore`.`media` as m "
						+ "JOIN `bookstore`.`bookMedia` bm ON m.mediaId = bm.mediaID "
						+ "JOIN `bookstore`.`book` b ON b.bookID = bm.bookID "
						+ "WHERE b.bookId = ?";
		
		List<Media> listMedias = executeQuery(sql, new MapperMedia(), bookId);
		return listMedias;
	}

	@Override
	public List<Media> getBlogMedias(int blogId) {
		return null;
	}
}