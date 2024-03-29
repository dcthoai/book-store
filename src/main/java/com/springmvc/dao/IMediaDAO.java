package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Media;

public interface IMediaDAO extends IGenericDAO<Media>{
	public List<Media> getBookMedias(int productId);
	public List<Media> getBlogMedias(int blogId);
}