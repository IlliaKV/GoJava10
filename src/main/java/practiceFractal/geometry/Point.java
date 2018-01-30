package practiceFractal.geometry;

public class Point {
    public static final Point ZERO = new Point(0,0);
    private double x, y;

    public Point(){
        this(1,1);
    }

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double calcLength(Point otherPoint){
        return Math.sqrt(Math.pow(x - otherPoint.x, 2) + Math.pow(y - otherPoint.y, 2));
    }

    public double calcLength(){
        return calcLength(ZERO);
    }

    public Point normalize(){
        return new Point(
                x/calcLength(),
                y/calcLength()
        );
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point minus(Point otherPoint){
        return new Point(
                x - otherPoint.x,
                y - otherPoint.y
        );
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

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
