package com.springmvc.model;

public class BookMedia {
	private int bookId, mediaId;

	public BookMedia() {
		super();
	}

	public BookMedia(int bookId, int mediaId) {
		super();
		this.bookId = bookId;
		this.mediaId = mediaId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getMediaId() {
		return mediaId;
	}

	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}
}