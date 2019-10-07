package com.aureole.dto;

import java.sql.Timestamp;

public class BookDTO extends AbstractDTO<BookDTO> {
	private Timestamp createdDate;
	private String bookName;
	private String author;
	private int quantity;
	private float price;
	private int period;
	private String description;
	private String categoryName;
	private int categoryId;
	
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public BookDTO(String bookName, String author, int quantity, float price, int period, String categoryName) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.quantity = quantity;
		this.price = price;
		this.period = period;
		this.categoryName = categoryName;
	}
	public BookDTO() {
		super();
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
/*	@Override
	public String toString() {
		return "com.aureole.dto.BookDTO[ id=" + "id" + " ]";
	}*/

}
