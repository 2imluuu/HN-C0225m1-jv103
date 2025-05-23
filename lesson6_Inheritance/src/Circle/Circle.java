package Circle;

public class Circle {
    private double radius = 1.0;
    private String color = "black";

    public Circle(){};
    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }

    public double Area(){
        return Math.PI * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString(){
        return "Color :" + this.color + ", Radius :" + this.radius + ", Area: " + Area();
    }
}
