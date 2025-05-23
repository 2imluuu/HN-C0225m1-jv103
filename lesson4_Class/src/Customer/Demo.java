package Customer;

public class Demo {
    public static void main(String[] args) {
        Customer nv1 = new Customer("Chau","vmduc9x@gmail.com","096666666");
        Customer nv2 = new Customer(1,"Duc","vmduc9x@Gmail.com","0965555555","22/2/2022",100);
        System.out.println("nv1 name: "+nv1.getName());
        nv1.displayInfo();
        nv1.setId(1);
        nv1.setTotalPurchases(20);
        nv1.setPhone("012345678");
        nv1.displayInfo();
    }
}
