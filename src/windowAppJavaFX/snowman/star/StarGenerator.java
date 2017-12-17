package windowAppJavaFX.snowman.star;

import javafx.scene.layout.Pane;

public class StarGenerator {
    private static final int NUMBER_OF_ANGLES = 11;
    private static final int NUMBER_OF_RAYS = NUMBER_OF_ANGLES/2;
    private static final double PERCENT = 37.5;
    private static final int HUNDRED = 100;
    private static final double STAR_ANGLE_R = Math.toRadians(-18);//угол поворота звезды
    private static final double DELTA_ANGLE_R = Math.PI / NUMBER_OF_RAYS;
    private static final int DEFAUL_X = 400;
    private static final int DEFAUL_Y = 300;
    private static final int DEFAUL_RADIUS = 250;

    private Point centre;
    private double radius;

    private double innerRadius;
    private Line[] lines;
    private Point[] points;

    public StarGenerator(){
        this(DEFAUL_X, DEFAUL_Y, DEFAUL_RADIUS);
    }
    public StarGenerator(double X, double Y, double radius){
        centre      = new Point(X, Y);
        this.radius = radius;
        points      = new Point[NUMBER_OF_ANGLES];
        lines       = new Line[NUMBER_OF_ANGLES];
        innerRadius = (radius/HUNDRED) * PERCENT;
        createPoints();
    }

    private void createPoints(){
        for (int i = 0; i < NUMBER_OF_ANGLES; i++) {
            double angleR   = STAR_ANGLE_R + i * DELTA_ANGLE_R;
            points[i]       = new Point(Math.cos(angleR),  Math.sin(angleR));
            if ((i & 1) == 0) {
//                points[i].setX(points[i].getX() * radius + centre.getX());
//                points[i].setY(points[i].getY() * radius + centre.getY());
                points[i] = points[i].multiply(radius).plus(centre);
            } else {
//                points[i].setX(points[i].getX() * innerRadius + centre.getX());
//                points[i].setY(points[i].getY() * innerRadius + centre.getY());
                points[i] = points[i].multiply(innerRadius).plus(centre);
            }
        }
    }

    public void draw(Pane root){
        for (int i = 0; i < NUMBER_OF_ANGLES; i++)
        {
            if (i != 0)
            {
                lines[i] = new Line(points[i-1], points[i]);
                lines[i].draw(root);
            }
        }
    }
}
