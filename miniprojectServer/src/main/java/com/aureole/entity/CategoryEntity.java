package com.aureole.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class CategoryEntity {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name ="CODE", columnDefinition="nvarchar(10)")
	private String code;
	@Column(name = "TYPENAME", columnDefinition="nvarchar(50)")
	private String typeName;
	
	@OneToMany(mappedBy = "bookType")
	private List<BookEntity> books = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<BookEntity> getBooks() {
		return books;
	}

	public void setBooks(List<BookEntity> books) {
		this.books = books;
	}
	
}
