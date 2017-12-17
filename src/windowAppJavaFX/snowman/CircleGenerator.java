package windowAppJavaFX.snowman;

import javafx.scene.layout.Pane;
import javafx.scene.paint.*;

public class CircleGenerator {
    private static final int COLOR_VALUES = 255;

    private double      minRadius;
    private double      maxRadius;
    private int         countCircles;
    private Circle[]    circles;

    private int         stepForRGB;

    public CircleGenerator(){
        this(100, 100, 1);
    }
    public CircleGenerator(double minRadius, double maxRadius, int countCircles){
        this.maxRadius      = maxRadius;
        this.minRadius      = minRadius;
        this.countCircles   = countCircles;
        circles             = new Circle[countCircles];

        stepForRGB = stepForRGB();

        for(int i=0; i<countCircles; i++){
            Point point;
            double radius = radiusGenerator();
            if(i==0){
                point = new Point();
            }
            else if(i==1){
                point = new Point(circles[0].getCentre().getX()-circles[0].getRadius()/4, circles[0].getCentre().getY()-circles[0].getRadius()/4);
            }
            else if(i==2){
                point = new Point(circles[0].getCentre().getX()+circles[0].getRadius()/4, circles[0].getCentre().getY()-circles[0].getRadius()/4);
            }
            else if(i==3){
                point = new Point();
            }
            else{
                point = new Point(circles[0].getCentre().getX(), circles[0].getCentre().getY() + sumRadiuses(i) + radius);
            }

            if(i==1 || i==2){
                circles[i] = new Circle(radiusGenerator(minRadius/3, minRadius/7), point);
            }else if(i==3){
                circles[i] = new Circle(radiusGenerator(minRadius/3, minRadius/7), point);
            }
            else {
                circles[i] = new Circle(radius, point);
            }
        }
    }

    private double radiusGenerator(){
        return minRadius + Math.random()*(maxRadius-minRadius) ;
    }

    private double radiusGenerator(double maxRadius, double minRadius){
        return minRadius + Math.random()*(maxRadius-minRadius);
    }

//    private void draw(int countCircles, Pane root){
//        circles[countCircles-1].draw(root);
//        if(countCircles == 1) return;
//        draw(--countCircles, root);
//    }
//
//    public void draw(Pane root){
//        draw(countCircles, root);
//    }
    public void draw(Pane root){
        for(int i=0; i<countCircles; i++){
            circles[i].draw(root);
        }
    }

    public void draw(Pane root, String colorFill){
        for(int i=0; i<countCircles; i++){
            circles[i].setColorFill(colorFill);
            circles[i].draw(root);
        }
    }

    public void drawGradiently(Pane root){
        int rgb1 = COLOR_VALUES;
        int rgb2 = COLOR_VALUES - stepForRGB;
        for(int i=0; i<countCircles; i++){
            if(i==1 || i==2 || i==3){
                circles[i].draw(root);
            }else {
                LinearGradient linearGrad = new LinearGradient(
                        0,   // start X
                        0,   // start Y
                        0,   // end X
                        1, // end Y
                        true, // proportional
                        CycleMethod.REFLECT, // cycle colors
                        // stops
                        new Stop(0.0, Color.rgb(rgb1, rgb1,rgb1)),
                        new Stop(1.0, Color.rgb(rgb2,rgb2,rgb2)));
                circles[i].drawGradiently(root, linearGrad);
                rgb1 -= stepForRGB;
                rgb2 = rgb2 - stepForRGB < 0 ? 0 : rgb2 - stepForRGB;
            }
        }
    }

    private double sumRadiuses(int numberCircle){
        double sumRadiuses = circles[0].getRadius();
        for(int i=4; i<numberCircle; i++){
            sumRadiuses += circles[i].getRadius()*2;
        }
        return sumRadiuses;
    }

    private int stepForRGB(){
        return COLOR_VALUES / countCircles+1;
    }
}
