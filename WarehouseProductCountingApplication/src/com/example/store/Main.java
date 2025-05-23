package com.example.store;

public class Main {
    public static void main(String[] args) {
        // Truoc khi tao mon hang
        // Before creating any products
        System.out.println("Initial product count: " + Product.getTotalProducts());

        // Tao hang hoa
        // Create products
        Product laptop = new Product("Laptop",1000);
        Product smartphone = new Product("Smartphone",500);
        Product table = new Product("Table",300);

        // sau khi khoi tao hang hoa
        // After creating products
        System.out.println("Current products count: " + Product.getTotalProducts());

        //Hien thong tin hang hoa
        //Display products Info

        System.out.println("\n--- Products Information ---");
        laptop.displayInfo();

        //truy cap price thong qua getter

        System.out.println("Laptop price: "+laptop.getPrice());

        // Update Price by setter
        laptop.setPrice(2000);
        System.out.println("Laptop new price: "+laptop.getPrice());

        //try update with invalid value
        laptop.setPrice(-100);
        System.out.println("Laptop new price: "+laptop.getPrice());
    }
}
