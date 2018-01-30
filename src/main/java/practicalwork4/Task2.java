package practicalwork4;

import java.util.Scanner;

public class Task2 {

    static int toDegree(int x, int n){
        if (n <= 0) return 1;
        return toDegree(x,n-1) * x;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Написать рекурсивную функцию возведения числа-Х в степень-N
        System.out.println("Введите число Х:");
        int x = in.nextInt();
        System.out.println("Введите степень N:");
        int n = in.nextInt();

        System.out.println("Результат возведения числа-"+x+" в степень-"+n+" = " + toDegree(x, n));
    }
}
