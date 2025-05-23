package Circle;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle = new Circle(2.0,"Blue");
        System.out.println(circle);
        System.out.println();

        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
        cylinder.setColor("red");
        cylinder.setRadius(2);
        cylinder.setHeight(2);
        System.out.println(cylinder);
    }
}
