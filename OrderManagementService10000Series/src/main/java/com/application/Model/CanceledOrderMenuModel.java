package com.application.Model;

import jakarta.persistence.Embeddable;

@Embeddable
public class CanceledOrderMenuModel {
	
	private int orderId;
	private int dishId;
	private String dishName;
	private long dishPrice;
	private int sGst;
	private int cGst;
	
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

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
	public int getsGst() {
		return sGst;
	}
	public void setsGst(int sGst) {
		this.sGst = sGst;
	}
	public int getcGst() {
		return cGst;
	}
	public void setcGst(int cGst) {
		this.cGst = cGst;
	}
}
