package com.aish.bookstoreconsumer.model;

public class Book {

	private String bookId;
	private String bookName;
	private String authorName;
	private String discription;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String bookId, String bookName, String authorName, String discription) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.discription = discription;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", discription="
				+ discription + "]";
	}
	
	
	
	
}
