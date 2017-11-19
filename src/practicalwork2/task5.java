package practicalwork2;

import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {
        System.out.print("Введите A: ");
        Scanner in = new Scanner(System.in);
        double A = in.nextDouble();
        System.out.print("Введите B: ");
        double B = in.nextDouble();
        System.out.print("Введите C: ");
        double C = in.nextDouble();
        boolean q1 = A>B && A>C;
        boolean q2 = B>A && B>C;
        boolean q3 = C>A && C>B;
        System.out.println("1. является ли A наибольшим числом = " + q1);
        System.out.println("2. является ли B наибольшим числом = " + q2);
        System.out.println("3. является ли C наибольшим числом = " + q3 + "\n");
        boolean q4 = A<B && A<C;
        boolean q5 = B<A && B<C;
        boolean q6 = C<A && C<B;
        System.out.println("4. является ли A наименьшим числом = " + q4);
        System.out.println("5. является ли B наименьшим числом = " + q5);
        System.out.println("6. является ли C наименьшим числом = " + q6 + "\n");
        boolean q7 = (A>B && A<C) || (A<B && A>C);
        boolean q8 = (B>A && B<C) || (B<A && B>C);
        boolean q9 = (C>A && C<B) || (C<A && C>B);
        System.out.println("7. является ли A промежуточным числом между B и C = " + q7);
        System.out.println("8. является ли B промежуточным числом между A и C = " + q8);
        System.out.println("9. является ли C промежуточным числом между A и B = " + q9);
    }
}
