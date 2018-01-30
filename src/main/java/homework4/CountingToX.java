package homework4;

import java.util.Scanner;

public class CountingToX {

    static void outCountingToX(int X){
        for(int i=1; i<=X;i++){
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите число Х:");
        int X = in.nextInt();
        outCountingToX(X);
    }
}
