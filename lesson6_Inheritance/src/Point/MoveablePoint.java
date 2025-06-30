package Point;

public class MoveablePoint extends Point {
    private float xSpeed = 0f;
    private float ySpeed = 0f;

    MoveablePoint(float x, float y){
        super(x, y);
    }

    MoveablePoint(float x, float y, float xSpeed, float ySpeed){
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    MoveablePoint(){}

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void getSpeed(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed(){
        return new float[]{xSpeed, ySpeed};
    }

    @Override
    public String toString(){
        return  "(" + getX()
                + "," +  getY()
                + ")" + ", speed = ("
                + getXSpeed()
                + "," +  getYSpeed();
    }

    public MoveablePoint move(){
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);
        return this;
    }
}
