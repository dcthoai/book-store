package com.springmvc.model;

import java.sql.Timestamp;

public class Voucher extends AbstractModel {
	private String voucherName, voucherCode, descriptions;
	private float discount;
	private int quantity;
	private long priceMinimumApplied, priceMaximumApplied;
	private Timestamp expirationDate;

	public Voucher() {
		super();
	}

	public String getVoucherName() {
		return voucherName;
	}

	public void setVoucherName(String voucherName) {
		this.voucherName = voucherName;
	}

	public String getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
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