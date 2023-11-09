package com.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.application.Entity.CanceledOrders;

@Component
public interface CanceledOrdeManagementRepository extends JpaRepository<CanceledOrders,Integer> {

}
