package com.jsp.foodapp.entities;

import java.util.List;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public List<FoodOrders> getfoodOrders() {
		return foodOrders;
	}
	public void setFo(List<FoodOrders> foodOrders) {
		this.foodOrders = foodOrders;
	}
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
private int id;
private String name;
@Column(nullable=false,unique=true)
private String email;
@Column(unique=true)
private String password;
private long mobilenumber;
@OneToMany
private List<FoodOrders> foodOrders;

}
