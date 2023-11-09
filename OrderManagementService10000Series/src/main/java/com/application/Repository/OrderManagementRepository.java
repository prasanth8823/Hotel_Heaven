package com.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.application.Entity.Orders;


@Component
public interface OrderManagementRepository extends JpaRepository<Orders, Integer> {
	
}
