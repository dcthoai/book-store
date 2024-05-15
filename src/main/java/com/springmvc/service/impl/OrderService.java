package com.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.impl.OrderDAO;
import com.springmvc.model.Order;
import com.springmvc.service.IOrderService;

@Service
public class OrderService implements IOrderService{
	
	@Autowired
	private OrderDAO orderDao;

	@Override
	public List<Order> getOrderByCustomer(String username) {
		return null;
	}

	@Override
	public List<Order> getAllOrder() {
		return orderDao.getAllOrder();
	}

}
