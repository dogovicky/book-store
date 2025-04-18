package com.capricon.web.model;

public class Book {
	
	private String bookId;
	private String title;
	private String author;
	private String isbn;
	private String price;
	
	public Book(String title, String author, String isbn, String price) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	

}
