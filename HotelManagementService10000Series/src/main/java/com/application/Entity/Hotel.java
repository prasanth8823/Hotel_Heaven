package com.application.Entity;


import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Hotel {

	@Id
	@GeneratedValue(generator = "Hotel_Generator", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "Hotel_Generator", sequenceName = "Hotel_Sequence", allocationSize = 1, initialValue = 1000)
	private int hotelId;

	@Column(unique = true, nullable = false)
	private String hotelName;

	@Column(unique = true, nullable = false)
	private long phoneNumber;

	@Column(unique = true, nullable = false)
	private String emailId;

	@Column(nullable = false)
	private String streetName;

	@Column(nullable = false)
	private String areaName;

	@Column(nullable = false)
	private String stateName;

	@Column(nullable = false)
	private String districtName;

	@Column(nullable = false)
	private long pincode;

	@Column(nullable = false)
	private String gstNumber;
	
	@Column(nullable = false)
	private LocalTime openTime;
	
	@Column(nullable = false)
	private LocalTime closeTime;
	
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

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public LocalTime getOpenTime() {
		return openTime;
	}

	public void setOpenTime(LocalTime openTime) {
		this.openTime = openTime;
	}

	public LocalTime getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(LocalTime closeTime) {
		this.closeTime = closeTime;
	}
	
}
