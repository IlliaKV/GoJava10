package practicalwork2;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        System.out.print("Введите A: ");
        Scanner in = new Scanner(System.in);
        double A = in.nextDouble();
        System.out.print("Введите B: ");
        double B = in.nextDouble();
        System.out.print("Результат " + A + "+" + B + " = " + (A+B));
    }
}
