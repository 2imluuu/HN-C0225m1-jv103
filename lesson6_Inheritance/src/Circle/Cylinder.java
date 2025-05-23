package Circle;

import java.awt.geom.Area;

public class Cylinder extends Circle {
    private double height = 1.0;

    public Cylinder(){};
    public Cylinder(double radius,String color,double height){
        super(radius,color);
        this.height = height;
    }
    public double Volume(){
        return  Math.PI*Math.pow(getRadius(),2)*height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString(){
        return "Cylinder Radius: " + getRadius()
                + ", Height: " + getHeight()
                + ", Color: " + getColor()
                + ", Volume: " + Volume();
    }
}
