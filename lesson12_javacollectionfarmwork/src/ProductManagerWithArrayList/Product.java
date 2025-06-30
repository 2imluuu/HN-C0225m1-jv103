package ProductManagerWithArrayList;

public class Product {
    private String name;
    private double price;
    private int ID;
    private int quantity;

    public Product(){};

    public Product(int ID, String name, double price, int quantity) {
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.ID=ID;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return  "name= " + name + ", price= " + price + ", quantity= " + quantity;
    }
}
