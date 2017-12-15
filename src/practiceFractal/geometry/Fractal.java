package practiceFractal.geometry;

import javafx.scene.layout.Pane;

public class Fractal {
    private int     depth;  //глубина фрактала (кол-во итераций отрисовки)
    private double   percentOffset; //отступ от начала линии предыдущей итерации отрисовки

    public Fractal(int depth, double percentOffset){
        this.depth          = depth;
        this.percentOffset  = percentOffset;
    }

    private void draw(int currentDepth, Triangle triangle, Pane root){
        triangle.draw(root);
        if (currentDepth == 1) return;
        draw(--currentDepth, new Triangle(
                triangle.getL1().getPointOnLine(percentOffset),
                triangle.getL2().getPointOnLine(percentOffset),
                triangle.getL3().getPointOnLine(percentOffset)
        ), root);
    }

    public void draw(Pane root){
        Point p1 = new Point(80, 100);
        Point p2 = new Point(210, 50);
        Point p3 = new Point(330, 150);
        Triangle triangle = new Triangle(p1, p2, p3);
        draw(depth, triangle, root);

    }
}
