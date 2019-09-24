package com.ideas2it.luxitrip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//import com.ideas2it.luxitrip.model.Stop;

@Entity
@Table(name = "fare")
public class Fare {
   
	@Id
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	private Stop source;
	
	@ManyToOne
	private Stop destination;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "status")
	private boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Stop getSource() {
		return source;
	}

	public void setSource(Stop source) {
		this.source = source;
	}

	public Stop getDestination() {
		return destination;
	}

	public void setDestination(Stop destination) {
		this.destination = destination;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Fare [id=" + id + ", source=" + source + ", destination=" + destination + ", price=" + price
				+ ", status=" + status + "]";
	}
	
	
	
}
