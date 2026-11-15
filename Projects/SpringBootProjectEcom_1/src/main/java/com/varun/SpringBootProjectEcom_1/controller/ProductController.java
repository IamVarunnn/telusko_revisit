package com.varun.SpringBootProjectEcom_1.controller;

import com.varun.SpringBootProjectEcom_1.model.Product;
import com.varun.SpringBootProjectEcom_1.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {

    private final ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){

        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.ACCEPTED);
    }
}
