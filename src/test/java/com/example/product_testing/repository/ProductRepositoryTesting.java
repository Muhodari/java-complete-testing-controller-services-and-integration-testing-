package com.example.product_testing.repository;


import com.example.product_testing.Repository.ProductRepository;
import com.example.product_testing.models.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
public class ProductRepositoryTesting {
    @Autowired
   private ProductRepository productRepository;

  @Test
  public void findAll_succes(){
      List<Product> products = productRepository.findAll();
      assertEquals(0,products.size()) ;
  }

  @Test
    public void findOne_success(){
      Optional<Product> product = productRepository.findById(1);
      assertTrue(product.isPresent());

  }









}
