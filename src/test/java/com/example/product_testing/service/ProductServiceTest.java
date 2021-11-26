package com.example.product_testing.service;

import com.example.product_testing.Repository.ProductRepository;
import com.example.product_testing.Services.ProductServices;
import com.example.product_testing.models.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepositoryMock;
    @InjectMocks
    private ProductServices productServices;


 @Test
    public void getAll_success() {
  when(productRepositoryMock.findAll()).thenReturn(Arrays.asList(
          new Product(1,"money",2,5,"product 1"),
          new Product(2,"pesa",56,23,"money pays All")
          ));
  assertEquals(10,productServices.getAll().get(0).getValue() );
 }





}
