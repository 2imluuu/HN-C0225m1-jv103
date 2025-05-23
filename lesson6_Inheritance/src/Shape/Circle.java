package Shape;

public class Circle extends Shape{
    private double radius = 1;
    public Circle(){
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(double radius,String color,boolean filled){
        super(color,filled);
        this.radius = radius;
    }
    public double getArea(double radius){
        return 2*Math.PI*radius;
    }
    public double getPerimeter(double radius){
        return Math.PI*radius*radius;
    }

    @Override
    public String toString() {
        return "A circle with radius: " + getRadius() + ", which is a subclass of " + super.toString();
    }
}
