package com.ideas2it.luxitrip.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name  = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "number")
	private String number;
	@Column(name = "email_id")
	private String emailId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	private String role;
	@Column(name = "status")
	private boolean status;
	

}
