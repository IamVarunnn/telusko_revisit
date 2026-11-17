package com.varun.SpringBootProjectEcom_1.dto;

import java.util.List;

public record OrderRequest(
        String customerName,
        String email,
        List<OrderItemRequest> items
) {
}
