package windowAppJavaFX.snowman.star;

public class Point {
    private double x, y;

    public Point(){
        this(450,100);
    }

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point plus(Point otherPoint){
        return new Point(
                x + otherPoint.x,
                y + otherPoint.y
        );
    }

    public Point multiply(double value){
        return new Point(
                x * value,
                y * value
        );
    }
}
