package com.springmvc.model;

import java.sql.Timestamp;

public class Media extends AbstractModel {
	private String mediaName, mediaPath, mediaType;
	private int mediaSize;
	
	public Media() {
		super();
	}

	public Media(int id, Timestamp createdDate, Timestamp modifiedDate, String createdBy, String modifiedBy) {
		super(id, createdDate, modifiedDate, createdBy, modifiedBy);
	}

	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public String getMediaPath() {
		return mediaPath;
	}

	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public int getMediaSize() {
		return mediaSize;
	}

	public void setMediaSize(int mediaSize) {
		this.mediaSize = mediaSize;
	}
}