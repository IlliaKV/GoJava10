package practicalwork2;

import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        System.out.print("Введите ширину: ");
        Scanner in = new Scanner(System.in);
        double A = in.nextDouble();
        System.out.print("Введите висоту: ");
        double B = in.nextDouble();
        System.out.print("Площадь прямоугольника " + A + "*" + B + " = " + (A*B));
    }
}
