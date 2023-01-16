package com.mbamistore.orderservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mbamistore.orderservice.dto.OrderRequest;
import com.mbamistore.orderservice.model.Order;
import com.mbamistore.orderservice.model.OrderItems;
import com.mbamistore.orderservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderItems> orderItems = orderRequest.getOrderItemsDto()
                .stream()
                .map(orderItemDto -> {
                    OrderItems orderItem = new OrderItems();
                    orderItem.setOrderItemNumber(UUID.randomUUID().toString());
                    orderItem.setOrderItemName(orderItemDto.getOrderItemName());
                    orderItem.setOrderItemPrice(orderItemDto.getOrderItemPrice());
                    orderItem.setOrderItemQuantity(orderItemDto.getOrderItemQuantity());
                    orderItem.setOrderItemTotal(orderItemDto.getOrderItemTotal());
                    orderItem.setOrderItemCurrency(orderItemDto.getOrderItemCurrency());
                    return orderItem;
                })
                .toList();
        order.setOrderItems(orderItems);
        orderRepository.save(order);

    }

    public Order getOrder(Long orderId) {
        return null;
    }

    public List<Order> getAllOrders() {
        return null;
    }

    public Order updateOrder(Long orderId, Order order) {
        return null;
    }

    public void deleteOrder(Long orderId) {
        // TODO delete order
    }

    
}
