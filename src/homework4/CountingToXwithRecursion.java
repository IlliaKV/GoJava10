package homework4;

import java.util.Scanner;

public class CountingToXwithRecursion {

    static String outCountingToX(int X){
        if (X<=0) return "";
        return outCountingToX(X-1) + " " + X;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите число Х:");
        int X = in.nextInt();
        System.out.println(outCountingToX(X));
    }
}