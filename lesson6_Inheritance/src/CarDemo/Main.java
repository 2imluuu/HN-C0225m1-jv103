package CarDemo;

public class Main {
    public static void main(String[] args) {
        LuxuryCar lx  = new LuxuryCar("Lexus");
        lx.Massage();
        lx.driving();
        System.out.println(lx.getColor());
        lx.setColor("blue");
        System.out.println(lx.getColor());
        System.out.println(lx.getName());

        Car vin = new Car();
        vin.setName("VF5");
        vin.setColor("White");
        System.out.println(vin.getColor() + vin.getName());
        vin.driving();
    }
}
