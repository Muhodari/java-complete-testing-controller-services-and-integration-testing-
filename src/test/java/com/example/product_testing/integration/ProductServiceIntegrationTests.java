package com.example.product_testing.integration;

import com.example.product_testing.models.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceIntegrationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getAll_success() throws  Exception{
        String response = this.testRestTemplate.getForObject("/all-products",String.class);
        JSONAssert.assertEquals("[{id:101},{id:102},{id:103},{id:104}]",response,false);

    }

 @Test
 public void  getById_successObject() throws Exception{

     Product product= testRestTemplate.getForObject("/all-products/103",Product.class);
     assertEquals("Product3",product.getName());
     assertEquals(9000,product.getValue());

 }



}
