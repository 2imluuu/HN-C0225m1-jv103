package Shape;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("red",false);
        System.out.println(shape);
        System.out.println();

        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle(3.5,"indigo",false);
        System.out.println(circle);
        System.out.println();

        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.0, 3.5);
        System.out.println(rectangle);

        rectangle = new Rectangle(2.0,3.0,"orange",false);
        System.out.println(rectangle);
        System.out.println();

        Triangle  triangle = new Triangle();
        System.out.println(triangle);
        triangle.setSide1(2);
        triangle.setSide2(3);
        System.out.println(triangle);
        System.out.println(triangle.getHalfPerimeter());
    }
}
