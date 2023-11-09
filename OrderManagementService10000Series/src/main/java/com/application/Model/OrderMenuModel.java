package com.application.Model;

import jakarta.persistence.Embeddable;

@Embeddable
public class OrderMenuModel {
	
	private int dishId;
	private String dishName;
	private long dishPrice;
	private int quantity;
	
	public int getDishId() {
		return dishId;
	}
	
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public long getDishPrice() {
		return dishPrice;
	}
	public void setDishPrice(long dishPrice) {
		this.dishPrice = dishPrice;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
