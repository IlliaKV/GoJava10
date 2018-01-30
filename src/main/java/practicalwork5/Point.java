package practicalwork5;
/*

Создать класс - Point
Хранит в себе x,y(float или double) координаты точки в двухмерном пространстве.

Имеет не статик функцию -
float calcLength(Point otherPoint)
Она возвращает расстояние между двумя точками

 */
public class Point {
    double x;
    double y;

    public Point() {
        this(0, 0);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double calcLength(Point otherPoint) {
        return Math.sqrt(Math.pow(otherPoint.x - this.x, 2) + Math.pow(otherPoint.y - this.y, 2));
    }
}
