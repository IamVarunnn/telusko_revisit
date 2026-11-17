package com.varun.SpringBootProjectEcom_1.service;

import com.varun.SpringBootProjectEcom_1.dto.OrderRequest;
import com.varun.SpringBootProjectEcom_1.dto.OrderResponse;
import com.varun.SpringBootProjectEcom_1.model.Order;
import com.varun.SpringBootProjectEcom_1.repoistory.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;

    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = new Order();
        String orderId = "ORD" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        order.setOrderId(orderId);
        order.setCustomerName(orderRequest.customerName());
        order.setEmail(orderRequest.email());
        order.setStatus("PLACED");
        order.setOrderDate(LocalDate.now());

        return null;
    }

    public List<OrderResponse> getAllOrderResponses() {
        return null;
    }
}
