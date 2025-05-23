package Point2D;

public class Main {
    public static void main(String[] args) {
        Point2D point1 = new Point2D(1.2f,2.2f);
        Point2D point2 = new Point2D(3f,5f);
        System.out.println(point1);
        System.out.println(point2);
        System.out.println();

        Point3D point3 = new Point3D(1.2f,2.2f,3.3f);
        System.out.println(point3);
        point3.setXYZ(3f,4f,5f);
        System.out.println(point3);
    }
}
