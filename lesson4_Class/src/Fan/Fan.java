package Fan;

public class Fan {
    int SLOW = 1;
    int MEDIUM = 2;
    int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public String getColor() {
        return color;
    }

    public double getRadius() {
        return radius;
    }

    public boolean isOn() {
        return on;
    }

    public int getSpeed() {
        return speed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public Fan(){};
    public String toString(){
        if(!on){
            return "Fan is on" + " " + speed + " " + color + " " + radius;
        }
        else {
            return "Fan is off" + " " + color + " " + radius;
        }
    }
}
