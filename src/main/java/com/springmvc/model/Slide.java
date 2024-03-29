package com.springmvc.model;

import java.sql.Timestamp;

public class Slide extends AbstractModel{
	private int slideMedia;
	private String caption, content , slideLink;

	public Slide() {
		super();
	}

	public Slide(int id, Timestamp createdDate, Timestamp modifiedDate, String createdBy, String modifiedBy) {
		super(id, createdDate, modifiedDate, createdBy, modifiedBy);
	}

	public int getSlideMedia() {
		return slideMedia;
	}

	public void setSlideMedia(int slideMedia) {
		this.slideMedia = slideMedia;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getSlideLink() {
		return slideLink;
	}

	public void setSlideLink(String slideLink) {
		this.slideLink = slideLink;
	}
}