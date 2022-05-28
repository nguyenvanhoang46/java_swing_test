/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projcetjavaswing.model;

/**
 *
 * @author Admin
 */
public class Product {
    private int id;
    private String nameproduct;
    private int category_id;
    private int price;
    private int quantity;
    private String unit;
    private String image;

    public Product() {
    }

    public Product(int id, String nameproduct, int category_id, int price, int quantity, String unit, String image) {
        this.id = id;
        this.nameproduct = nameproduct;
        this.category_id = category_id;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
        this.image = image;
    }

    public Product(String nameproduct, int category_id, int price, int quantity, String unit, String image) {
        this.nameproduct = nameproduct;
        this.category_id = category_id;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
        this.image = image;
    }

   

    public Product(String nameproduct, int category_id, int price, int quantity, String unit) {
        this.nameproduct = nameproduct;
        this.category_id = category_id;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", nameproduct=" + nameproduct + ", category_id=" + category_id + ", price=" + price + ", quantity=" + quantity + ", unit=" + unit + ", image=" + image + '}';
    }

    
    
}
