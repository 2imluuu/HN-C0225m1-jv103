package ProductManagerWithArrayList;

import java.util.*;

public class ProductManager {
    private List<Product> productList = new ArrayList<Product>();

    public void addProduct(Product product){
        productList.add(product);
    }

    public void showProducts(){
        if(productList.isEmpty()){
            System.out.println("Is Empty");
        } else {
            for(Product product : productList){
                System.out.println(product);
            }
        }
    }

    public void removeProduct(Product product){
        productList.remove(product);
    }

    public void editProductById(int id){
        Scanner sc = new Scanner(System.in);
        if( id < 0 || id >= productList.size() ){
            throw new IllegalArgumentException("Id not valid");
        }
        for(Product product : productList){
            if(product.getID() == id){
                System.out.println("Enter new name:");
                String newname = sc.nextLine();
                System.out.println("Enter new price:");
                double newprice = sc.nextDouble();
                System.out.println("Enter new quantity:");
                int newquantity = sc.nextInt();
                product.setName(newname);
                product.setPrice(newprice);
                product.setQuantity(newquantity);
            }
        }
        System.out.println("Product updated successfully!");
        showProducts();
    }

    public void removeProductById(int id){
        if( id < 0 || id >= productList.size() ){
            throw new IllegalArgumentException("Id not valid");
        }
        for(Product product : productList){
            if(product.getID() == id){
                productList.remove(product);
            }
        }
        System.out.println("Product deleted successfully!");
        showProducts();
    }

    public void findProductByName(String name){
        for(Product product : productList){
            if(product.getName().equals(name)){
                System.out.println(product);
            }
        }
    }

    public void sortByPriceAscending(){
        productList.sort((a,b)-> Double.compare(a.getPrice(), b.getPrice()));
        showProducts();
    }

    public void sortByPriceDescending(){
        productList.sort((a,b)-> Double.compare(b.getPrice(), a.getPrice()));
        showProducts();
    }

}
