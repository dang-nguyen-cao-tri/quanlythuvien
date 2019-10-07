package com.aureole.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "MEMBER")
public class MemberEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition="Timestamp")
	private Timestamp createdDate;
	
	@Column(name="NAME", columnDefinition="nvarchar(50)")
	private String name;
	@Column(name="EMAIL")
	private String email;
	@Column(name="BIRTHDAY", columnDefinition="DATE")
	private Date birthDay;
	@Column(name="GENDER", columnDefinition="nvarchar(10)")
	private String gender;
	
	@OneToMany(mappedBy = "member")
	private List<BookMemberEntity> members = new ArrayList<>();
	
	public List<BookMemberEntity> getMembers() {
		return members;
	}
	public void setMembers(List<BookMemberEntity> members) {
		this.members = members;
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

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
