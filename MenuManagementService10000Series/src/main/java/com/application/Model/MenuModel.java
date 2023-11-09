package com.application.Model;

import org.springframework.stereotype.Component;

@Component
public class MenuModel {
	private int hotelId;
	private String hotelName;
	private int dishId;
	private String dishName;
	private long dishPrice;	
	
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
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
}
