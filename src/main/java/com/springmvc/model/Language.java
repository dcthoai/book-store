package com.springmvc.model;

import java.sql.Timestamp;

public class Language extends AbstractModel{
	private String languageName;

	public Language() {
		super();
	}
	
	public Language(String lnaguageName) {
		super();
	}

	public Language(int id, Timestamp createdDate, Timestamp modifiedDate, String createdBy, String modifiedBy) {
		super(id, createdDate, modifiedDate, createdBy, modifiedBy);
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
}