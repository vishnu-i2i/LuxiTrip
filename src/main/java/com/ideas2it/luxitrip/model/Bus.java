package com.ideas2it.luxitrip.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Proxy;
import javax.persistence.Table;

import java.util.ArrayList;

import com.ideas2it.luxitrip.model.Seat;

@Entity
@Table(name = "bus")
public class Bus {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length=11, nullable=false, unique=true)
    private int id;
	
    @Column(name = "bus_number", length=20, nullable=true)
	private String busNumber;
	
    @Column(name = "capacity", length=11, nullable=true)
	private int capacity;
	
    @Column(name = "operator", length=20, nullable=true)
	private String operator;
    
    @Column(name = "type", length=20, nullable=true)
    private String type;
    
    @Column(name = "status", length=20, nullable=true)
    private boolean status;
	
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="bus_id")
	private List<Seat> seats = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	public String toString() {
	    return (id+busNumber+capacity+operator);
	}
}
