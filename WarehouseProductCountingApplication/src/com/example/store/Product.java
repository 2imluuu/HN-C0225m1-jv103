package com.example.store;

public class Product {
    private static int totalProducts = 0;

    private int id;
    private String name;
    private double price;
    private static final double VAT = 0.1;

    static {
        System.out.println("Product class is being initialized");
        if (totalProducts == 0) {
            System.out.println("No products have been created");
        }
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.id = ++totalProducts;
    }

    public static int getTotalProducts() {
        return totalProducts;
    }

    public static void setTotalProducts(int totalProducts) {
        Product.totalProducts = totalProducts;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Price cannot be negative");
        }
    }

    public double getPriceWithVAT() {
        return this.price *(1+VAT);
    }

    public static void printProductsInfo(){
        System.out.println("Total product: "+totalProducts);
    }

    public void displayInfo(){
        System.out.println("Product ID: "+this.id);
        System.out.println("Name: "+this.name);
        System.out.println("Price: "+this.price);
        System.out.println("Price with vat: "+this.getPriceWithVAT());
        System.out.println("Total products in inventory: " + Product.getTotalProducts());
        System.out.println("Using instance to call static method: " + this.getTotalProducts());
    }
}
