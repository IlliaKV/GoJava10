package practicalwork5;

public class Main {
    public static void main(String[] args) {
        CircleGenerator circleGenerator = new CircleGenerator();
        circleGenerator.generate(6);
        System.out.println("количество столкновений = " + circleGenerator.calcCountOfCollisions());
        circleGenerator.drawCircles();
    }
}
