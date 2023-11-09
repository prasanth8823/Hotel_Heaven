package com.application.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.Entity.Orders;
import com.application.Model.OrderRequstBody;

@Service
public interface OrderManagementService {
	
	String createOrder(OrderRequstBody orders);
	Orders getorderDetails(int orderId);
	List<Orders> getAllOrder();
	Orders alterOrder(Orders fields);
	String cancelOrder(int orderId);
}
