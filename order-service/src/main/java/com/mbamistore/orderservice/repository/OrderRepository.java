package com.mbamistore.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbamistore.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    //
}
