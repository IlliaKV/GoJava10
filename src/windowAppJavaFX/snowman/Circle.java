package windowAppJavaFX.snowman;

import javafx.scene.layout.Pane;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import java.util.Random;

public class Circle {
    private String colorFill;

    private double radius;
    private Point centre;
    private javafx.scene.shape.Circle circleFX;

    public Circle() {
        this(1, new Point());
    }

    public Circle(double radius, Point centre) {
        this.radius = radius;
        this.centre = centre;
        colorFill = "#ffffff";
    }

    private String generateRandomColor() {
        String[] letters = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        String rgb = "#";
        for (int i = 0; i < 6; i++ ) {
            rgb += letters[(int) Math.round(Math.random() * 15)];
        }
        return rgb;
    }

    public void draw(Pane root){
        circleFX = new javafx.scene.shape.Circle(centre.getX(), centre.getY(), radius);
        circleFX.setFill(Paint.valueOf(colorFill));
        circleFX.setStroke(Paint.valueOf(generateRandomColor()));

        root.getChildren().addAll(circleFX);
    }

    public void drawGradiently(Pane root, LinearGradient gradient){
        circleFX = new javafx.scene.shape.Circle(centre.getX(), centre.getY(), radius);
        circleFX.setFill(gradient);
        circleFX.setStroke(Paint.valueOf(generateRandomColor()));

        root.getChildren().addAll(circleFX);
    }


    public Point getCentre() {
        return centre;
    }

    public double getRadius() {
        return radius;
    }

    public void setColorFill(String colorFill) {
        this.colorFill = colorFill;
    }
}
