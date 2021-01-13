package com.alvesjefs.msorders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvesjefs.msorders.domain.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
