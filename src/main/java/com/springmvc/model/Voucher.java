package com.springmvc.model;

import java.sql.Timestamp;

public class Voucher extends AbstractModel {
	private String title, code, description;
	private float discount;
	private int quantity;
	private long priceMinimumApplied, priceMaximumApplied;
	private Timestamp expirationDate;

	public Voucher() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getPriceMinimumApplied() {
		return priceMinimumApplied;
	}

	public void setPriceMinimumApplied(long priceMinimumApplied) {
		this.priceMinimumApplied = priceMinimumApplied;
	}

	public long getPriceMaximumApplied() {
		return priceMaximumApplied;
	}

	public void setPriceMaximumApplied(long priceMaximumApplied) {
		this.priceMaximumApplied = priceMaximumApplied;
	}

	public Timestamp getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Timestamp expirationDate) {
		this.expirationDate = expirationDate;
	}
}