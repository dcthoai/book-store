package com.springmvc.model;

public class Author extends AbstractModel{
	private String name;

	public Author() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
