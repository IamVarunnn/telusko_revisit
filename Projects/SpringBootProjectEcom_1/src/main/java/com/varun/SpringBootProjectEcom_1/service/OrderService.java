package com.varun.SpringBootProjectEcom_1.service;

import com.varun.SpringBootProjectEcom_1.dto.OrderItemRequest;
import com.varun.SpringBootProjectEcom_1.dto.OrderItemResponse;
import com.varun.SpringBootProjectEcom_1.dto.OrderRequest;
import com.varun.SpringBootProjectEcom_1.dto.OrderResponse;
import com.varun.SpringBootProjectEcom_1.model.Order;
import com.varun.SpringBootProjectEcom_1.model.OrderItem;
import com.varun.SpringBootProjectEcom_1.model.Product;
import com.varun.SpringBootProjectEcom_1.repoistory.OrderRepo;
import com.varun.SpringBootProjectEcom_1.repoistory.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductRepo productRepo;

    private final OrderRepo orderRepo;

    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = new Order();
        String orderId = "ORD" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        order.setOrderId(orderId);
        order.setCustomerName(orderRequest.customerName());
        order.setEmail(orderRequest.email());
        order.setStatus("PLACED");
        order.setOrderDate(LocalDate.now());

        List<OrderItem> orderItems = new ArrayList<>();

        for(OrderItemRequest itemRequest : orderRequest.items()){

            Product product = productRepo.findById(itemRequest.productId()).orElseThrow(() -> new RuntimeException("Product not Found"));

            product.setStockQuantity(product.getStockQuantity() - itemRequest.quantity());

            OrderItem orderItem = OrderItem.builder()
                    .product(product)
                    .quantity(itemRequest.quantity())
                    .totalPrice(product.getPrice().multiply(BigDecimal.valueOf(itemRequest.quantity())))
                    .order(order)
                    .build();

            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);
        Order savedOrder =  orderRepo.save(order);

        List<OrderItemResponse> itemResponses = new ArrayList<>();

        for(OrderItem item : order.getOrderItems()){
            OrderItemResponse orderItemResponse = new OrderItemResponse(
                    item.getProduct().getName(),
                    item.getQuantity(),
                    item.getTotalPrice()
            );
            itemResponses.add(orderItemResponse);
        }


        OrderResponse orderResponse = new OrderResponse(savedOrder.getOrderId(), savedOrder.getCustomerName(), savedOrder.getEmail(), savedOrder.getStatus(), savedOrder.getOrderDate(), itemResponses);

        return orderResponse;
    }

    public List<OrderResponse> getAllOrderResponses() {
        return null;
    }
}
