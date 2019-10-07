package com.aureole.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "BOOK")
public class BookEntity  {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition="Timestamp")
	private Timestamp createdDate;
	@Column( name = "BOOKNAME",columnDefinition="nvarchar(50)")
	private String bookName;
	@Column(name = "AUTHOR", columnDefinition="nvarchar(50)")
	private String author;
	@Column(name = "QUANTITY")
	private int quantity;
	@Column(name = "PRICE")
	private float price;
	@Column(name = "PERIOD")
	private int period;
	@Column(name = "DESCRIPTION", columnDefinition="nvarchar(500)")
	private String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	
	@ManyToOne
    @JoinColumn(name = "BOOKTYPE_ID")
	private CategoryEntity bookType;
	
	@OneToMany(mappedBy = "book")
	private List<BookMemberEntity> books = new ArrayList<>();
	
	public List<BookMemberEntity> getBooks() {
		return books;
	}
	public void setBooks(List<BookMemberEntity> books) {
		this.books = books;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
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
	
	
	public CategoryEntity getCategoryEntity() {
		return bookType;
	}
	public void setCategoryEntity(CategoryEntity bookType) {
		this.bookType = bookType;
	}
	
}
