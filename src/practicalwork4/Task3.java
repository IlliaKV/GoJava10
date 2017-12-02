package practicalwork4;

import java.util.Scanner;

public class Task3 {

    static String fromAtoB(int a, int b){
        if (a > b) return "";
        return fromAtoB(a, b-1) + b + " ";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Написать рекурсивную функцию возведения числа-Х в степень-N
        System.out.println("Введите число A:");
        String A = in.nextLine();
        int a = Integer.parseInt(A);
        System.out.println("Введите число B:");
        String B = in.nextLine();
        int b = Integer.parseInt(B);

        System.out.println("Все числа от A до B включительно, в порядке возрастания:");
        System.out.println(fromAtoB(a, b));
    }
}
