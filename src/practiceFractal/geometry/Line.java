package practiceFractal.geometry;

import javafx.scene.layout.Pane;

public class Line {
    private Point p1, p2; //точки начала и конца линии
    private javafx.scene.shape.Line lineFx; //из пакета javafx для рисования

    public Line(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
        lineFx = new javafx.scene.shape.Line(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    public double calcLength(){
        return p1.calcLength(p2);
    }

    public Point getPointOnLine(double percent){
        //найти координаты вектора(лайна) и получить единичный вектор, поделив на его длину
        //далее умножить на на d, получим координаты точки, удаленной от начала координат на d в направлении заданного вектора
        return p2.minus(p1).normalize().multiply(calcLength()*percent).plus(p1);
    }

    public void draw(Pane root){
        root.getChildren().addAll(lineFx);
    }

    public void clear(Pane root){
        root.getChildren().clear();
    }

//    public Point getP1() {
//        return p1;
//    }
//
//    public Point getP2() {
//        return p2;
//    }
}
