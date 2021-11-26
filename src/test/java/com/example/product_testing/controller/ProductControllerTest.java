package com.example.product_testing.controller;


import com.example.product_testing.Controllers.ProductController;
import com.example.product_testing.Services.ProductServices;
import com.example.product_testing.models.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)

public class ProductControllerTest {

  @MockBean
    private ProductServices productServicesMock;
  @Autowired
    private MockMvc mockMvc;



   @Test
    public void getAll_success() throws Exception {
       List<Product> products= Arrays.asList(
               new Product(1,"monkey",2,2,"monkey market"),
               new Product(12,"banana",4,4,"banana market")
       );
    when(productServicesMock.getAll()).thenReturn(products);

       MockHttpServletRequestBuilder request= MockMvcRequestBuilders
               .get("/all-products")
               .accept(MediaType.APPLICATION_JSON);

       MvcResult result = mockMvc
               .perform(request)
               .andExpect(status().isOk())
               .andExpect(content()
                       .json("[{\"id\":1,\"name\":\"monkey\",\"price\":2,\"quantity\":2,\"description\":\"monkey market\"}," +
                               "{\"id\":12,\"name\":\"banana\",\"price\":4,\"quantity\":4,\"description\":\"banana market\"}]"))
               .andReturn();
   }


   @Test
    public void getByOne_404() throws Exception{
Product product = new Product(1,"sagamba",45,65,"welcome back again");
when(productServicesMock.getById(product.getId())).thenReturn(product);


MockHttpServletRequestBuilder request= MockMvcRequestBuilders
        .get("/all-products/2")
        .accept(MediaType.APPLICATION_JSON);

MvcResult result =mockMvc
        .perform(request)
        .andExpect(status().isNotFound())
        .andExpect(content().json("{\"status\":false,\"message\":\"Item not found\"}"))
        .andReturn();
    }








}
