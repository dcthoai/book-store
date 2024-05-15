package com.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.dao.IOrderDAO;
import com.springmvc.mapper.MapperOrder;
import com.springmvc.model.Order;

@Repository
public class OrderDAO extends AbstractDAO<Order> implements IOrderDAO {

	@Override
	public int insert(Order order) {
		String sql = "INSERT INTO `bookstore`.`order` ("
				+ " customerId, address, orderStatus, paymentStatus, shippingStatus, "
				+ " totalPrice, shippingCost, discount, totalPayment, paymentMethod, "
				+ " shippingUnit, shippingMethod, shipperPhone, orderDate, estimatedArrival, createdBy)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		int idOrder = executeInsert(sql, order.getCustomerId(),
										 order.getAddress(),
										 order.getOrderStatus(),
										 order.getPaymentStatus(),
										 order.getShippingStatus(),
										 order.getTotalPrice(),
										 order.getShippingCost(),
										 order.getDiscount(),
										 order.getTotalPayment(),
										 order.getPaymentMethod(),
										 order.getShippingUnit(),
										 order.getShippingMethod(),
										 order.getShipperPhone(),
										 order.getOrderDate(),
										 order.getEstimatedArrival(),
										 order.getCreatedBy());
		
		return idOrder;
	}

	@Override
	public int update(Order order) {
		String sql = "UPDATE `bookstore`.`order` SET "
				+ "    address = ?, "
				+ "    orderStatus = ?, "
				+ "    paymentStatus = ?, "
				+ "    shippingStatus = ?, "
				+ "    paymentMethod = ?, "
				+ "    shippingUnit = ?, "
				+ "    shippingMethod = ?, "
				+ "    shipperPhone = ?, "
				+ "    estimatedArrival = ?, "
				+ "    deliveredAt = ?, "
				+ "    modifiedBy = ? "
				+ "WHERE id = ?";
		
		int affectedRows = executeUpdate(sql, order.getAddress(),
											 order.getOrderStatus(),
											 order.getPaymentStatus(),
											 order.getShippingStatus(),
											 order.getPaymentMethod(),
											 order.getShippingUnit(),
											 order.getShippingMethod(),
											 order.getShipperPhone(),
											 order.getEstimatedArrival(),
											 order.getDeliveredAt(),
											 order.getModifiedBy());
	
		return affectedRows;
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM `bookstore`.`order` WHERE id = ?";
		
		int affectedRows = executeUpdate(sql, id);
		return affectedRows;
	}

	@Override
	public Order getById(int id) {
		String sql = "SELECT * FROM `bookstore`.`order` WHERE id = ?";
		
		List<Order> listOrders = executeQuery(sql, new MapperOrder(), id);
		
		return listOrders.isEmpty() ? null : listOrders.get(0);
	}

	@Override
	public List<Order> getOrderByCustomer(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrder() {
		String sql = "SELECT * FROM `bookstore`.`order`";
		
		List<Order> listOrders = executeQuery(sql, new MapperOrder());
		return listOrders;
	}
	
}
