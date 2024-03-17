package com.springmvc.model;

import java.sql.Timestamp;

public class Category extends AbstractModel{
	private String categoryName, descriptions;

	public Category() {
		super();
	}

	public Category(int id, Timestamp createdDate, Timestamp modifiedDate, String createdBy, String modifiedBy) {
		super(id, createdDate, modifiedDate, createdBy, modifiedBy);
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
}