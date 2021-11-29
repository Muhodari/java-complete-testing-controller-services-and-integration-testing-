package com.example.product_testing.Services;

import com.example.product_testing.Repository.ProductRepository;
import com.example.product_testing.dto.UpdateProductDto;
import com.example.product_testing.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

@Autowired
private ProductRepository productRepository;


public List<Product> getAll(){
    List<Product> products = productRepository.findAll();
    for (Product product:products){
        product.setValue(product.getQuantity()*product.getPrice());
    }
 return products;

}


public  Product getById(int id){
    Optional<Product> findById= productRepository.findById(id);
    if(findById.isPresent()){
        Product product= findById.get();
        product.setValue(product.getQuantity() * product.getPrice());
        return product;
    }
    return null;
}


public ResponseEntity<?> updateProduct(int id, UpdateProductDto dto){
Optional<Product> findById = productRepository.findById(id);
if(findById.isPresent()){
    Product product= findById.get();
    if(productRepository.existsByName(dto.getName()) &&
    !(product.getName().equalsIgnoreCase(dto.getName()))){
return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product name already exist");
    }
 product.setName(dto.getName());
 product.setPrice(dto.getPrice());
 product.setQuantity(dto.getQuantity());
 product.setDescription(dto.getDescription());

 productRepository.save(product);
 return ResponseEntity.status(HttpStatus.CREATED).body(product);
}

return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("product does not exists ");

}









public ResponseEntity<?> AddNewProduct( Product product){
    Optional<Product> productExist = productRepository.findById(product.getId());
    boolean NameExist = productRepository.existsByName(product.getName());
    Product newProduct= new Product();

    if(productExist.isPresent() || NameExist==true){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product already Exist");
        }

         newProduct.setId(product.getId());
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setQuantity(product.getQuantity());
        newProduct.setDescription(product.getDescription());

        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }








}
