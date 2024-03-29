package com.springmvc.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.impl.MediaDAO;
import com.springmvc.model.Media;
import com.springmvc.service.user.IMediaService;

@Service
public class MediaService implements IMediaService{
	@Autowired
	private MediaDAO mediaDAO;

	@Override
	public Media getMediaById(int id) {
		return mediaDAO.getById(id);
	}

	@Override
	public int insertMedia(Media media) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateMedia(Media media) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMedia(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}