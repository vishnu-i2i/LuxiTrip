package com.ideas2it.luxitrip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name  = "id")
	private int id;
	@Column(name = "name", unique = true, length=20, nullable=false)
	private String name;
	@Column(name = "number", length=10, nullable=true,  unique = false)
	private String number;
	@Column(name = "email_id", length=20, nullable=true,  unique = true)
	private String emailId;
	@Column(name = "password", length=20, nullable=false)
	private String password;
	@Column(name = "role", length=20, nullable=false)
	private String role;
	@Column(name = "status", length=5, nullable=false)
	private boolean status;

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

	public String toString() {
        return (getId() + "\t" + getName() + "\t"
               + getNumber() + "\t" 
               + getEmailId() + "\t" + getRole() + "\t" + isStatus());  
    }
	

}
