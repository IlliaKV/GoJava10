package practicalwork2;

import java.util.Scanner;

public class task6 {
    public static void main(String[] args) {
        System.out.print("Введите A: ");
        Scanner in = new Scanner(System.in);
        double A = in.nextDouble();
        System.out.print("Введите B: ");
        double B = in.nextDouble();
        System.out.print("Введите C: ");
        double C = in.nextDouble();
        boolean q1 = A==B || A==C;
        boolean q2 = B==A || B==C;
        boolean q3 = C==A || C==B;
        System.out.println("1. равняется ли A хотя бы одному из других чисел = " + q1);
        System.out.println("2. равняется ли B хотя бы одному из других чисел = " + q2);
        System.out.println("3. равняется ли C хотя бы одному из других чисел = " + q3 + "\n");
        boolean q4 = A>B || A>C;
        boolean q5 = B>A || B>C;
        boolean q6 = C>A || C>B;
        System.out.println("4. A больше хотя бы одного из других чисел = " + q4);
        System.out.println("5. B больше хотя бы одного из других чисел = " + q5);
        System.out.println("6. C больше хотя бы одного из других чисел = " + q6);
    }
}
