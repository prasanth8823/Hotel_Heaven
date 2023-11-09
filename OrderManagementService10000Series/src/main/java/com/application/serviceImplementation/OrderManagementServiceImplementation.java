package com.application.serviceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.application.Entity.CanceledOrders;
import com.application.Entity.Orders;
import com.application.Model.CanceledOrderMenuModel;
import com.application.Model.Menu;
import com.application.Model.OrderHotelModel;
import com.application.Model.OrderMenuModel;
import com.application.Model.OrderRequstBody;
import com.application.Model.OrderUserModel;
import com.application.Repository.CanceledOrdeManagementRepository;
import com.application.Repository.OrderManagementRepository;
import com.application.Service.OrderManagementService;

import jakarta.persistence.EntityNotFoundException;

@Component
public class OrderManagementServiceImplementation implements OrderManagementService {

	@Autowired
	EntityRemoteServiceImplementation imp;
	@Autowired
	OrderManagementRepository repo;
	@Autowired
	CanceledOrdeManagementRepository canceledRepo;
	@Autowired
	JavaMailSender mailSender;

	private Orders order = new Orders();
	private int totalitems = 0;
	private float subtotal = 0;
	private float grandtotal = 0;

	@Override
	public String createOrder(OrderRequstBody orders) {

		OrderHotelModel hotel = imp.getHotel(orders.getHoteId());
		OrderUserModel user = imp.getUser(orders.getUserId());
		ArrayList<OrderMenuModel> orderMenu = new ArrayList<>();

		for (Menu dishId : orders.getMenu()) {
			OrderMenuModel menu = imp.getMenu(dishId.getDishId(), orders.getHoteId());
			menu.setQuantity(dishId.getQuantity());
			orderMenu.add(menu);
		}

		for (OrderMenuModel orderMenuModel : orderMenu) {
			totalitems = +orderMenuModel.getQuantity();
		}

		for (OrderMenuModel orderMenuModel : orderMenu) {
			subtotal = +orderMenuModel.getDishPrice() * orderMenuModel.getQuantity();
		}

		grandtotal = subtotal + (subtotal * (order.getcGst() + order.getsGst() / 100));
		order.setHotelId(hotel.getHotelId());
		order.setHotelName(hotel.getHotelName());
		order.setPhoneNumber(hotel.getPhoneNumber());
		order.setEmailId(hotel.getEmailId());
		order.setGstNumber(hotel.getGstNumber());
		order.setCustomerId(user.getUserId());
		order.setCustomerFirstName(user.getFirstName());
		order.setCustomerLastName(user.getLastName());
		order.setCustomerEmailId(user.getEmailId());
		order.setCustomerPhoneNumber(user.getPhoneNumber());
		order.setTotalItems(totalitems);
		order.setSubTotal(subtotal);
		order.setGrandTotal(grandtotal);
		order.setOrderedItems(orderMenu);
		repo.save(order);
		ConfirmationOrder(order.getCustomerEmailId());
		return "order created successfully";
	}

	private void ConfirmationOrder(String emailId) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		try (Scanner input = new Scanner(System.in)) {
			mailMessage.setTo(emailId);
			mailMessage.setSubject(
					"Order Confirmation: Your Order " + order.getOrderId() + " Has Been Successfully Created");
			mailMessage.setText("Dear " + order.getCustomerFirstName() + " " + order.getCustomerLastName() + ",\n\n\n"
					+ "We are delighted to inform you that your order has been successfully created. Below are the details of your order:\n\n\n"
					+ "order Id: " + order.getOrderId() + "\n" + order.getOrderedDate() + "\n\n\n"
					+ "Order Details:\n\n" + order.getOrderedItems());
			mailSender.send(mailMessage);
		}
	}

	private void CancellationOrder(String emailId) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		try (Scanner input = new Scanner(System.in)) {
			mailMessage.setTo(emailId);
			mailMessage.setSubject(
					"Order Cancellation: Your Order " + order.getOrderId() + " Has Been Successfully Canceled");
			mailMessage.setText("Dear " + order.getCustomerFirstName() + " " + order.getCustomerLastName() + ",\n\n\n"
					+ "We hope this email finds you well. We regret to inform you that your order with the following details has been canceled\n\n\n"
					+ "order Id: " + order.getOrderId() + "\n" + order.getOrderedDate() + "\n\n\n"
					+ "Order Details:\n\n" + order.getOrderedItems() + "Total Amount: " + order.getGrandTotal()
					+ "\n\n\n\n\nWe understand that this may be disappointing, and we apologize for any inconvenience this may have caused. Please rest assured that any payment made will be refunded promptly\n\n\nIf you have any questions regarding the cancellation or if you would like to discuss alternative options, please don't hesitate to contact our customer support team. We are here to assist you.\n\n\nThank you for considering [Your Company Name], and we appreciate your understanding.\n\n\nBest regards,\n\n\n"
					+ order.getHotelName() + "\n" + order.getEmailId() + "\n" + order.getPhoneNumber());

			mailSender.send(mailMessage);
		}
	}

	@Override
	public Orders getorderDetails(int orderId) {
		Optional<Orders> findById = repo.findById(orderId);
		if (findById.isPresent()) {
			Orders orders = findById.get();
			return orders;
		} else {
			throw new EntityNotFoundException("orderId not found" + orderId);
		}
	}

	@Override
	public List<Orders> getAllOrder() {
		List<Orders> findAll = repo.findAll();
		if (!findAll.isEmpty()) {
			return findAll;
		} else {
			throw new EntityNotFoundException("order list is empty");
		}
	}

	@Override
	public Orders alterOrder(Orders fields) {
		return null;
	}

	@Override
	public String cancelOrder(int orderId) {
		Optional<Orders> findById = repo.findById(orderId);

		if (findById.isPresent()) {
			Orders orders = findById.get();
			CanceledOrders canceledOrders = new CanceledOrders();

			List<OrderMenuModel> orderedItems = orders.getOrderedItems();
			List<CanceledOrderMenuModel> canceledOrderMenuModels = new ArrayList<>();
			
			for (OrderMenuModel ordereditem : orderedItems) {
				CanceledOrderMenuModel canceledorders = new CanceledOrderMenuModel();
				canceledorders.setOrderId(canceledOrders.getOrderId());
				canceledorders.setDishId(ordereditem.getDishId());
				canceledorders.setDishName(ordereditem.getDishName());
				canceledorders.setDishPrice(ordereditem.getDishPrice());

				canceledOrderMenuModels.add(canceledorders);
			}

			canceledOrders.setOrderId(orders.getOrderId());
			canceledOrders.setOrderedDate(orders.getOrderedDate());
			canceledOrders.setOrderedTime(orders.getOrderedTime());
			canceledOrders.setHotelId(orders.getHotelId());
			canceledOrders.setHotelName(orders.getHotelName());
			canceledOrders.setPhoneNumber(orders.getPhoneNumber());
			canceledOrders.setEmailId(orders.getEmailId());
			canceledOrders.setGstNumber(orders.getGstNumber());
			canceledOrders.setCustomerId(orders.getCustomerId());
			canceledOrders.setCustomerFirstName(orders.getCustomerFirstName());
			canceledOrders.setCustomerLastName(orders.getCustomerLastName());
			canceledOrders.setCustomerEmailId(orders.getCustomerEmailId());
			canceledOrders.setCustomerPhoneNumber(orders.getCustomerPhoneNumber());
			canceledOrders.setCanceledOrderedItems(canceledOrderMenuModels);
			canceledOrders.setTotalItems(orders.getTotalItems());
			canceledOrders.setSubTotal(orders.getSubTotal());
			canceledOrders.setcGst(orders.getcGst());
			canceledOrders.setsGst(orders.getsGst());
			canceledOrders.setGrandTotal(orders.getGrandTotal());
			canceledRepo.save(canceledOrders);
			repo.deleteById(orderId);
			CancellationOrder(canceledOrders.getCustomerEmailId());
		}
		return "deleted";
	}

}
