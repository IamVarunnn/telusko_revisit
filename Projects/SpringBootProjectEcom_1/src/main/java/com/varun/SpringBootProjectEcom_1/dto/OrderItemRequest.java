package com.varun.SpringBootProjectEcom_1.dto;

public record OrderItemRequest(
        int productId,
        int quantity
) {
}
