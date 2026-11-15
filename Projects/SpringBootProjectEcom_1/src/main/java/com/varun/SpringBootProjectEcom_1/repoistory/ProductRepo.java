package com.varun.SpringBootProjectEcom_1.repoistory;

import com.varun.SpringBootProjectEcom_1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
