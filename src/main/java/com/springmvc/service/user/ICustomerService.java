package com.springmvc.service.user;

import com.springmvc.model.Customer;

public interface ICustomerService {
	public int insertCustomer(Customer customer);
	public boolean updateCustomer(Customer customer);
	public boolean deleteCustomer(int id);
	public Customer getCustomerById(int id);
	public Customer getCustomerByEmail(String email);
	public Customer getCustomerByPhone(String phone);
}