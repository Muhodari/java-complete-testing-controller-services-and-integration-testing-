package com.example.product_testing.service;

import com.example.product_testing.Repository.ProductRepository;
import com.example.product_testing.Services.ProductServices;
import com.example.product_testing.dto.UpdateProductDto;
import com.example.product_testing.models.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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


 @Test
    public  void updateAll_success(){
     UpdateProductDto dto= new UpdateProductDto("money",3,4,"let update new product");
     Product product = new Product(1,"money",54,5,"let update data given");
     when(productRepositoryMock.findById(1)).thenReturn(Optional.of(product));
     when(productRepositoryMock.existsByName(dto.getName())).thenReturn(true);
     when(productRepositoryMock.save(product)).thenReturn(product);

     ResponseEntity<?> updateProduct=  productServices.updateProduct(1,dto);
     assertTrue(updateProduct.getStatusCode().is2xxSuccessful());

 }


 @Test
    public void  update_notFound(){
     UpdateProductDto dto= new UpdateProductDto("money",5,6,"amazing product");

     when(productRepositoryMock.findById(1)).thenReturn(Optional.empty());
     ResponseEntity<?> UpdateProduct = productServices.updateProduct(1,dto);
     assertTrue(UpdateProduct.getStatusCodeValue()==404);

 }





}
