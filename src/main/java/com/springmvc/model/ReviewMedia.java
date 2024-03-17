package com.springmvc.model;

public class ReviewMedia {
	private int reviewId, mediaId;

	public ReviewMedia() {
		super();
	}

	public ReviewMedia(int reviewId, int mediaId) {
		super();
		this.reviewId = reviewId;
		this.mediaId = mediaId;
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