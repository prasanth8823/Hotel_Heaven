package com.application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.Entity.Orders;
import com.application.Model.OrderRequstBody;
import com.application.serviceImplementation.OrderManagementServiceImplementation;

@RestController
public class OrderManagementController {
	
	@Autowired
	OrderManagementServiceImplementation imp;
	
	@PostMapping(value = "/HavenHotel/Order/create")
	private String postOrder(@RequestBody OrderRequstBody requstBody ) {
		String createOrder = imp.createOrder(requstBody);
		return createOrder;
	}
	
	@GetMapping(value = "/HavenHotel/Order/retrive")
	private Orders getOrder(@RequestParam int orderId) {
		Orders getorderDetails = imp.getorderDetails(orderId);
		return getorderDetails;
	}
	
	@GetMapping(value = "/HavenHotel/Orders")
	private List<Orders> getAllOrders() {
		List<Orders> allOrder = imp.getAllOrder();
		return allOrder;
	}
	
	@DeleteMapping(value = "/HavenHotel/Order/delete")
	private String deleteOrder(@RequestParam int orderId) {
		String cancelOrder = imp.cancelOrder(orderId);
		return cancelOrder;
	}
}
