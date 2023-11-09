package com.application.Entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.application.Model.OrderMenuModel;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Orders {

	@Id
	@GeneratedValue(generator = "OrdersGenerator", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "OrdersGenerator", sequenceName = "OrdersSequence", allocationSize = 200, initialValue = 1)
	private int orderId;

	@Column(nullable = false)
	private LocalTime orderedTime = LocalTime.now();

	@Column(nullable = false)
	private LocalDate orderedDate = LocalDate.now();

	@Column(nullable = false)
	private int hotelId;

	@Column(nullable = false)
	private String hotelName;

	@Column(nullable = false)
	private long phoneNumber;

	@Column(nullable = false)
	private String emailId;

	@Column(nullable = false)
	private String gstNumber;

	@Column(nullable = false)
	private int customerId;

	@Column(nullable = false)
	private String customerFirstName;

	@Column(nullable = false)
	private String customerLastName;

	@Column(nullable = false)
	private String customerEmailId;

	@Column(nullable = false)
	private long customerPhoneNumber;

	@ElementCollection
	@Column(nullable = false)
	private List<OrderMenuModel> orderedItems = new ArrayList<>();

	@Column(nullable = false)
	private int totalItems;

	@Column(nullable = false)
	private float subTotal;

	@Column(nullable = false)
	private int cGst = 9;

	@Column(nullable = false)
	private int sGst = 9;

	@Column(nullable = false)
	private float grandTotal;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalTime getOrderedTime() {
		return orderedTime;
	}

	public void setOrderedTime(LocalTime orderedTime) {
		this.orderedTime = orderedTime;
	}

	public LocalDate getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(LocalDate orderedDate) {
		this.orderedDate = orderedDate;
	}

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

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

	public long getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(long customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public List<OrderMenuModel> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(List<OrderMenuModel> orderedItems) {
		this.orderedItems = orderedItems;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public int getcGst() {
		return cGst;
	}

	public void setcGst(int cGst) {
		this.cGst = cGst;
	}

	public int getsGst() {
		return sGst;
	}

	public void setsGst(int sGst) {
		this.sGst = sGst;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

}
