package com.example.product_testing.Repository;

import com.example.product_testing.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

boolean existsByName(String name);

}
