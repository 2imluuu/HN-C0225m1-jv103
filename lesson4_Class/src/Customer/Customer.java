package Customer;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String joinDate;
    private double totalPurchases;

    public Customer(){
    };
    public Customer(String name){
        this.name = name;
    }
    public Customer(String name, String email, String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    public Customer(int id, String name, String email, String phone, String joinDate, double totalPurchases){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.joinDate = joinDate;
        this.totalPurchases = totalPurchases;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public double getTotalPurchases() {
        return totalPurchases;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotalPurchases(double totalPurchases) {
        this.totalPurchases = totalPurchases;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void makePurchase(double amount){
        this.totalPurchases += amount;
    }
    public void displayInfo(){
        System.out.println("Name: "+name);
        System.out.println("Email: "+email);
        System.out.println("Phone: "+phone);
        System.out.println("Total Purchases: "+totalPurchases);
    };
}
