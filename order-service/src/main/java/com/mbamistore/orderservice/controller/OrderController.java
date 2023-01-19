package com.mbamistore.orderservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.mbamistore.orderservice.dto.OrderRequest;
import com.mbamistore.orderservice.model.Order;
import com.mbamistore.orderservice.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    //
    private final OrderService orderService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody OrderRequest orderRequest) {
        log.info("OrderRequest: {}", orderRequest);
        return "Order created successfully";
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable("id") Long orderId) {
        return orderService.getOrder(orderId);
    }
    //
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    //
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable("id") Long orderId, @RequestBody Order order) {
        return orderService.updateOrder(orderId, order);
    }
    //
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Long orderId) {
        orderService.deleteOrder(orderId);
    }
}
