package com.example.product_testing.Controllers;


import com.example.product_testing.Repository.ProductRepository;
import com.example.product_testing.Services.ProductServices;
import com.example.product_testing.dto.UpdateProductDto;
import com.example.product_testing.models.Product;
import com.example.product_testing.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

   @Autowired
    private ProductServices productServices;

   @Autowired
    private ProductRepository productRepository;


//   get all product
   @GetMapping("/all-products")
    public List<Product> getAll(){

       return productServices.getAll();
   }


//   get product by id
@GetMapping("/all-products/{id}")
public ResponseEntity<?> getById(@PathVariable(name = "id")int id){

 Product product= productServices.getById(id);
 if(product != null){
     return  ResponseEntity.ok(product);
 }
return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIResponse(false,"Product Not Found"));
}


@PostMapping("/add-new-product")
    public  ResponseEntity<?> saveItem(@Valid Product product){
       
       if(productRepository.existsByName(product.getName())){
           return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                   .body(new APIResponse(false,"Product name already exixt"));
       }
       productRepository.save(product);

       return  ResponseEntity.ok(product);
}


@PutMapping("/update-product/{id}")
    public  ResponseEntity<?> updateProduct(@PathVariable(name="id")int id, @Valid UpdateProductDto dto){
       return  productServices.updateProduct(id,dto);

}


}
