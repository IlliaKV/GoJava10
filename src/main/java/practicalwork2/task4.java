package practicalwork2;

import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        System.out.print("Введите A: ");
        Scanner in = new Scanner(System.in);
        double A = in.nextDouble();
        System.out.print("Введите B: ");
        double B = in.nextDouble();
        boolean q1 = A==B;
        boolean q2 = A%B==0;
        boolean q3 = A>B;
        System.out.println("равны ли эти числа между собой = " + q1);
        System.out.println("делиться ли A на B без остатка = " + q2);
        System.out.println("A больше чем B = " + q3);
    }
}
