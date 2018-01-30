package practicalwork4;

import java.util.Scanner;

public class AdditionalTasks {

    static String from1toN(int n){
        if (n <= 0) return "";
        return from1toN(n-1) + n + " ";
    }

    static String fromAtoB(int a, int b){
        String str = "";
        if (a == b) str = Integer.toString(b) + " ";
        if (a < b) str = fromAtoB(a, b-1) + b + " ";
        else  if (a > b) str = fromAtoB(a, b + 1) + b + " ";

        return str;
    }

    static int akkerman(int m, int n){
        if (m == 0) return n+1;
        else if (m > 0 && n == 0) return akkerman(m-1, 1);
        else if (m > 0 && n > 0) return akkerman(m-1, akkerman(m, n-1));
        return akkerman(m,n);
    }

    static int exactDegree(int x, int n){
        if (x >= n) return x - exactDegree(x*x,n);
        return exactDegree(x*x,n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        //Написать рекурсивную функцию возведения числа-Х в степень-N
//        System.out.println("A: От 1 до n");
//        System.out.println("Введите число N:");
//        int n = in.nextInt();
//
//        System.out.println("Дано натуральное число n. Выведите все числа от 1 до n.");
//        System.out.println(from1toN(n));

////        Даны два целых числа A и В (каждое в отдельной строке)
////        Выведите все числа от A до B включительно, в порядке возрастания, если A < B, или в порядке убывания в противном случае
//        System.out.println("B: От A до B");
//        System.out.println("Введите число A:");
//        String A = in.nextLine();
//        int a = Integer.parseInt(A);
//        System.out.println("Введите число B:");
//        String B = in.nextLine();
//        int b = Integer.parseInt(B);
//
//        System.out.println("Все числа от A до B включительно:");
//        System.out.println(fromAtoB(a, b));

////        Даны два целых неотрицательных числа m и n, каждое в отдельной строке. Выведите A(m,n)
//        System.out.println("C: Функция Аккермана");
//        System.out.println("Введите число m:");
//        int m = in.nextInt();
//        System.out.println("Введите число n:");
//        int n = in.nextInt();
//
//        System.out.println("A(m,n) по функции Аккермана:");
//        System.out.println(akkerman(m, n));

//        Дано натуральное число N. Выведите слово YES, если число N является точной степенью двойки, или слово NO в противном случае.
//                Операцией возведения в степень пользоваться нельзя!
        System.out.println("D: Точная степень двойки");
        System.out.println("Введите число N:");
        int n = in.nextInt();

        System.out.println("Дано натуральное число n. Выведите все числа от 1 до n.");
        System.out.println(exactDegree(2, n));
    }
}
