package practicalwork2;

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        System.out.print("Введите A: ");
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        System.out.print("Введите B: ");
        double b = in.nextDouble();
        System.out.print("Введите C: ");
        double c = in.nextDouble();
        double p = (a+b+c)/2;
        System.out.print("Площадь треугольника  = " + (Math.sqrt(p*(p-a)*(p-b)*(p-c))));
    }
}
