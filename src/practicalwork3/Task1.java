package practicalwork3;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите A: ");
        int A = in.nextInt();
        System.out.println("Введите B: ");
        int B = in.nextInt();

        for(int i=0, ostatok = 10; i < Integer.toString(A).length();i++,ostatok*=10){
            System.out.print((A%ostatok)/(ostatok/10));
        }
        System.out.print(" ");

        for(int i=0, ostatok = 10; i < Integer.toString(B).length();i++,ostatok*=10){
            System.out.print((B%ostatok)/(ostatok/10));
        }
    }
}
