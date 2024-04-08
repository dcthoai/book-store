package com.springmvc.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.impl.CustomerDAO;
import com.springmvc.model.Customer;
import com.springmvc.service.user.ICustomerService;

@Service
public class CustomerService implements ICustomerService{

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public int insertCustomer(Customer customer) {
		int customerId = customerDAO.insert(customer);
		
		return customerId;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		int affectedRows = customerDAO.update(customer);
		
		return affectedRows > 0;
	}

	@Override
	public boolean deleteCustomer(int id) {
		int affectedRows = customerDAO.delete(id);
		
		return affectedRows > 0;
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer customer = customerDAO.getById(id);
		
		return customer;
	}
	
	@Override
	public Customer getCustomerByUserId(int userId) {
		Customer customer = customerDAO.getCustomerByUserId(userId);
		
		return customer;
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		Customer customer = customerDAO.getCustomerByEmail(email);
		
		return customer;
	}

	@Override
	public Customer getCustomerByPhone(String phone) {
		Customer customer = customerDAO.getCustomerByPhone(phone);
		
		return customer;
	}
}
