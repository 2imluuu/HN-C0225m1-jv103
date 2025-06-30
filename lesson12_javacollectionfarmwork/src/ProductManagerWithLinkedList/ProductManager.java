package ProductManagerWithLinkedList;

import java.util.*;

public class ProductManager {
    private List<Product> productList = new LinkedList<Product>();

    private Scanner sc = new Scanner(System.in);

    public void addProduct(){
        System.out.println("Adding product");
        System.out.println("Enter product id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter product name: ");
        String name = sc.nextLine();
        System.out.println("Enter product price: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.println("Enter product quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());
        productList.add(new Product(id,name,price,quantity));
        System.out.println("Product added successfully");
        showProductList();
    }

    void showProductList(){
        if(productList.isEmpty()){
            System.out.println("There is no products in the list");
        }
        for ( Product p : productList){
            System.out.println(p);
        }
    }

    void removeProduct(){

    }
}
