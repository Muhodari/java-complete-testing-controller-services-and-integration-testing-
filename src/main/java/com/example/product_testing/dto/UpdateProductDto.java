package com.example.product_testing.dto;

import com.sun.istack.NotNull;

public class UpdateProductDto {

    @NotNull
    private String name;
    @NotNull
    private int price;
    @NotNull
    private  int quantity;
    @NotNull
    private  String description;



//    constructor

    public UpdateProductDto(String name, int price, int quantity,String description) {
      super();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description=description;
    }

    public UpdateProductDto() {
        super();
    }

//    getters and setters


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
