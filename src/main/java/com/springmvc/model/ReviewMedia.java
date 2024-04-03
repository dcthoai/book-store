package com.springmvc.model;

public class ReviewMedia extends AbstractModel{
	private int reviewId, mediaId;

	public ReviewMedia() {
		super();
	}

	public long getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public long getMediaId() {
		return mediaId;
	}

	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}
}