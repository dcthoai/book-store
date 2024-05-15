package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Order;

public interface IOrderService {
	public List<Order> getOrderByCustomer(String username);
	public List<Order> getAllOrder();
}
