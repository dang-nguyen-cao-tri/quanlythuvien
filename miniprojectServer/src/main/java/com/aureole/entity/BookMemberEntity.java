package com.aureole.entity;

import java.sql.Timestamp;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name = "BORROW_INFO")
public class BookMemberEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column (name= "Borrow_Date", columnDefinition="Timestamp")
	private Timestamp borrowDate;

	@Column(name="RETURN_DATE")
	private Date returnDate;
	@Column(name="EXPIRATION_DATE")
	private Date expirationDate;
	@Column(name="STATUS", columnDefinition="nvarchar(20)")
	private String status;
	
	@ManyToOne
    @JoinColumn(name = "Book_id")
    private BookEntity book;
 
    @ManyToOne
    @JoinColumn(name = "Member_id")
    private MemberEntity member;
	
	public BookEntity getBook() {
		return book;
	}

	public void setBook(BookEntity book) {
		this.book = book;
	}

	public MemberEntity getMember() {
		return member;
	}

	public void setMember(MemberEntity member) {
		this.member = member;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Timestamp borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
}
