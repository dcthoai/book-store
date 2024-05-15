package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Customer;

public interface ICustomerDAO extends IGenericDAO<Customer>{
	public Customer getCustomerByUserId(int userId);
	public Customer getCustomerByEmail(String email);
	public Customer getCustomerByPhone(String phone);
	public List<Customer> getAllCustomer();
}
