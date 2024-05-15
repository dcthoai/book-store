package com.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.dao.ICustomerDAO;
import com.springmvc.mapper.MapperCustomer;
import com.springmvc.mapper.MapperUserCustom;
import com.springmvc.model.Customer;
import com.springmvc.model.UserCustom;

@Repository
public class CustomerDAO extends AbstractDAO<Customer> implements ICustomerDAO{

	@Override
	public int insert(Customer customer) {
		String sql = "INSERT INTO `bookstore`.`customer` (`userId`, `email`, `createdBy`) VALUES (?, ?, ?)";
		
		int customerId = executeInsert(sql, customer.getUserId(),
											customer.getEmail(),
											customer.getCreatedBy());
		
		return customerId;
	}

	@Override
	public int update(Customer customer) {
		String sql = "UPDATE `bookstore`.`customer` SET"
					+ "`userId` = ?, "
					+ "`avatarId` = ?, "
					+ "`fullname` = ?, "
					+ "`phone` = ?, "
					+ "`email` = ?, "
					+ "`birthday` = ?, "
					+ "`modifiedBy` = ? "
					+ "WHERE (`id` = ?)";
		
		int affectedRows = executeUpdate(sql, customer.getUserId(),
											  customer.getAvatarId(),
											  customer.getFullname(),
											  customer.getPhone(),
											  customer.getEmail(),
											  customer.getBirthday(),
											  customer.getModifiedBy(),
											  customer.getId());
		return affectedRows;
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM `bookstore`.`customer` WHERE (`id` = ?)";
		
		int affectedRows = executeUpdate(sql, id);
		return affectedRows;
	}

	@Override
	public Customer getById(int id) {
		String sql = "SELECT * FROM `bookstore`.`customer` WHERE (`id` = ?)";
		
		List<Customer> listCustomers = executeQuery(sql, new MapperCustomer(), id);
		
		return listCustomers.isEmpty() ? null : listCustomers.get(0);
	}
	
	@Override
	public Customer getCustomerByUserId(int userId) {
		String sql = "SELECT * FROM `bookstore`.`customer` WHERE (`userid` = ?)";
		
		List<Customer> listCustomers = executeQuery(sql, new MapperCustomer(), userId);
		
		return listCustomers.isEmpty() ? null : listCustomers.get(0);
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		String sql = "SELECT * FROM `bookstore`.`customer` WHERE (`email` = ?)";
		
		List<Customer> listCustomers = executeQuery(sql, new MapperCustomer(), email);
		
		return listCustomers.isEmpty() ? null : listCustomers.get(0);
	}

	@Override
	public Customer getCustomerByPhone(String phone) {
		String sql = "SELECT * FROM `bookstore`.`customer` WHERE (`phone` = ?)";
		
		List<Customer> listCustomers = executeQuery(sql, new MapperCustomer(), phone);
		
		return listCustomers.isEmpty() ? null : listCustomers.get(0);
	}

	@Override
	public List<Customer> getAllCustomer() {
		String sql = "SELECT * FROM `bookstore`.`customer`";
		
		List<Customer> customers = executeQuery(sql, new MapperCustomer());
		
		return customers;
	}
}