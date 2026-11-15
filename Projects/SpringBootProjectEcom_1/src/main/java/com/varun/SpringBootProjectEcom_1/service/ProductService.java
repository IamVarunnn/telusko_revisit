package com.varun.SpringBootProjectEcom_1.service;

import com.varun.SpringBootProjectEcom_1.model.Product;
import com.varun.SpringBootProjectEcom_1.repoistory.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}
