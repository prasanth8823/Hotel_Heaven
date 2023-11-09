package com.application.Models;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HotelModel {

	private int hotelId;
	private String hotelName;
	private long phoneNumber;
	private String emailId;
	private String streetName;
	private String areaName;
	private String districtName;
	private long pincode;
	private String stateName;
	private String gstNumber;
	private LocalTime openTime;
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
		String phonenumber = String.valueOf(phoneNumber);
		char[] charArray = phonenumber.toCharArray();
		int length = charArray.length;
		if (length == 10) {
			for (char number : charArray) {
				if (!Character.isDigit(number)) {
					throw new IllegalArgumentException("phone number contains characters: " + number);
				}
			}
		}
		if (length < 10) {
			throw new IllegalArgumentException("phone number is too short: " + phoneNumber);
		}
		if (length > 10) {
			throw new IllegalArgumentException("phone number is too long: " + phoneNumber);
		} else {
			this.phoneNumber = phoneNumber;
		}
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		String regex = "^[A-Za-z0-9+_.-]+@gmail\\.com$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(emailId);
		if (matcher.matches() && emailId.length() <= 64) {
			this.emailId = emailId;
		} else {
			throw new IllegalArgumentException("invalid emailId: " + emailId);
		}
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
		String pin = String.valueOf(pincode);
		int length = pin.length();
		if (length == 6) {
			this.pincode = pincode;
		} else {
			throw new IllegalArgumentException("invalid pincode: " + pincode);
		}
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		char[] charArray = gstNumber.toCharArray();
		if (charArray.length == 15) {
			for (int i = 0; i < gstNumber.length(); i++) {
				char value = gstNumber.charAt(i);
				if (i < 2 || (i > 6 && i < 11) || i == 12) {
					if (!Character.isDigit(value)) {
						throw new IllegalArgumentException("invalid GST number: " + gstNumber);
					}
				} else if ((i > 1 && i < 7) || i == 11 || i == 13) {
					if (!Character.isLetter(value)) {
						throw new IllegalArgumentException("invalid GST number: " + gstNumber);
					}
				} else {
					this.gstNumber = gstNumber;
				}
			}
		} else if (charArray.length < 10) {
			throw new IllegalArgumentException("GST number is too short: " + gstNumber);
		} else if (charArray.length > 10) {
			throw new IllegalArgumentException("GST number is too long: " + gstNumber);
		}
	}

	public LocalTime getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime time = LocalTime.parse(openTime, formatter);
		this.openTime = time;
	}

	public LocalTime getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime time = LocalTime.parse(closeTime, formatter);
		this.closeTime = time;
	}

}
