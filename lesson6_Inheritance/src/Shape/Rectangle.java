package Shape;

public class Rectangle extends Shape {
   private double width = 1.0;
   private double length = 1.0;

   public Rectangle(){};

   public Rectangle(double width, double length){
       this.width = width;
       this.length = length;
   }

   public Rectangle(double width, double length, String color, boolean filled){
       super(color, filled);
       this.width = width;
       this.length = length;
   }
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString(){
       return "A Rectangle with width: " + getWidth() + " and length: " + getLength()+", Which is a subclass of " + super.toString();
    }

}
