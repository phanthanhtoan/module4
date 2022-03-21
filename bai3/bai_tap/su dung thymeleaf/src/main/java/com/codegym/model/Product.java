package com.codegym.model;

public class Product {
    private int id;
    private String nameProduct;
    private double price;
    private int amount;

    public Product() {
    }

    public Product(int id, String nameProduct, double price, int amount) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
