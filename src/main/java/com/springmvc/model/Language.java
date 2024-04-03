package com.springmvc.model;

public class Language extends AbstractModel{
	private String languageName;

	public Language() {
		super();
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
}