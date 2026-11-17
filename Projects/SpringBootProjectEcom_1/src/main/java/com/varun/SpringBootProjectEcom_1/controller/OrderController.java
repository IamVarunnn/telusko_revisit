package com.varun.SpringBootProjectEcom_1.controller;

import com.varun.SpringBootProjectEcom_1.dto.OrderRequest;
import com.varun.SpringBootProjectEcom_1.dto.OrderResponse;
import com.varun.SpringBootProjectEcom_1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/orders/place")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){

        OrderResponse orderResponse = orderService.placeOrder(orderRequest);

        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponse>> getAllOrders(){

        List<OrderResponse> responses = orderService.getAllOrderResponses();

        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
