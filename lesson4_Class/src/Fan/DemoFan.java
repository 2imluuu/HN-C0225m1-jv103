package Fan;

public class DemoFan {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setOn(true);
        fan1.setColor("yeallow");
        fan1.setRadius(10);
        fan1.setSpeed(3);

        Fan fan2 = new Fan();
        fan2.setOn(false);
        fan2.setColor("blue");
        fan2.setRadius(5);
        fan2.setSpeed(2);

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
