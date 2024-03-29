package com.springmvc.dao;

public interface IGenericDAO<T> {
	public int insert(T t);
	public boolean update(T t);
	public boolean delete(int id);
	public T getById(int id);
}