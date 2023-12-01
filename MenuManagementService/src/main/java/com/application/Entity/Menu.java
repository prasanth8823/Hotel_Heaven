package com.application.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Menu {
	
	private int hotelId;
	private String hotelName;
	
	@Id
	@GeneratedValue(generator = "Menu_Generator" ,strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "Menu_Generator", sequenceName = "Menu_Sequence",initialValue = 1,allocationSize = 1)
	private int dishId;
	
	@Column(nullable = false)
	private String dishName;
	
	@Column(nullable = false)
	private long dishPrice;
	
	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
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

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

}
