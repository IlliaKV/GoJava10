package practicalwork5;

public class Circle {
    double radius;
    Point centre;

    public Circle() {
        this(0, new Point());
    }

    public Circle(double radius, Point centre) {
        this.radius = radius;
        this.centre = centre;
    }
    public boolean collisionCheck(Circle otherCircle){
        if(this.centre.calcLength(otherCircle.centre) < (this.radius + otherCircle.radius))
            return true;
        else
            return false;
    }
}
