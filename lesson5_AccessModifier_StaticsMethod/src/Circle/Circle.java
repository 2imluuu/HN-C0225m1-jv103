package Circle;

public class Circle {
    private double radius = 1.0;
    private String color = "red";
    Circle(){};
    Circle(double raidus){
        this.radius = raidus;
    };
    public double getRadius(){
        return radius;
    }
    public double getArea(){
        return Math.PI * radius * radius;
    }

}
