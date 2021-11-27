package com.example.product_testing.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Product {

 @Id
 private int id;
 private String name;
 private int price;
 private int quantity;
 private String description;


@Transient
    private int value;

//constructors


    public Product(int id, String name, int price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(int id, String name, int price, int quantity, String description) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public Product() {
        super();
    }


//    setters and getters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + "," +
                " quantity=" + quantity + ",description=" + description+" ,value=" + value
                + "]";
    }



}
