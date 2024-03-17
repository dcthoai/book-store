package com.springmvc.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Shipping extends AbstractModel {
	private int customerId, orderId;
	private long shippingCost;
	private String shippingAddress, shippingUnit, shippingMethod, shippingStatus, shipperPhone;
	private Date estimatedArival;
	
	public Shipping() {
		super();
	}

	public Shipping(int id, Timestamp createdDate, Timestamp modifiedDate, String createdBy, String modifiedBy) {
		super(id, createdDate, modifiedDate, createdBy, modifiedBy);
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public long getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(long shippingCost) {
		this.shippingCost = shippingCost;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getShippingUnit() {
		return shippingUnit;
	}

	public void setShippingUnit(String shippingUnit) {
		this.shippingUnit = shippingUnit;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public String getShippingStatus() {
		return shippingStatus;
	}

	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	public String getShipperPhone() {
		return shipperPhone;
	}

	public void setShipperPhone(String shipperPhone) {
		this.shipperPhone = shipperPhone;
	}

	public Date getEstimatedArival() {
		return estimatedArival;
	}

	public void setEstimatedArival(Date estimatedArival) {
		this.estimatedArival = estimatedArival;
	}
}