package windowAppJavaFX.snowman.star;

import javafx.scene.layout.Pane;

public class Line {
    private Point p1, p2; //точки начала и конца линии
    private javafx.scene.shape.Line lineFx; //из пакета javafx для рисования

    public Line(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
        lineFx = new javafx.scene.shape.Line(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    public void draw(Pane root){
        root.getChildren().addAll(lineFx);
    }
}
