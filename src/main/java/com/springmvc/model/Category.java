package com.springmvc.model;

public class Category extends AbstractModel{
	private String categoryName, descriptions;

	public Category() {
		super();
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