package ProductManagerWithArrayList;

public class Test {
    public static void main(String[] args) {
        Product SamSung = new Product(1,"SamSung",100,10);
        Product Apple = new  Product(2,"Apple",200,12);
        Product Oppo = new  Product(3,"Oppo",300,13);

        ProductManager productM = new ProductManager();
        productM.addProduct(SamSung);
        productM.addProduct(Apple);
        productM.addProduct(Oppo);

        productM.showProducts();

        productM.editProductById(2);

        productM.findProductByName("Oppo");

        productM.sortByPriceAscending();
    }
}
