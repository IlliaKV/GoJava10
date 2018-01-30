package practicalwork3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите размер массива A: ");
        int n = in.nextInt();

        int[] ArrayA = new int[n];

        for(int i=0; i<n;i++){
            System.out.print("A["+i+"]=");
            ArrayA[i]=in.nextInt();
        }
        System.out.println("Был введен массив A: ");
        for(int i=0; i<n;i++){
            System.out.println("A["+i+"]=" + ArrayA[i]);
        }
        System.out.println("Отзеркаленный массив A: ");
//        for(int i=n-1; i>=0;i--){
//            System.out.println("A["+i+"]=" + ArrayA[i]);
//        }
        for(int i=n-1, j=0; i>=n/2;i--,j++){
            int temp = ArrayA[j];
            ArrayA[j] = ArrayA[i];
            ArrayA[i] = temp;
        }
        for(int i=0; i<n;i++){
            System.out.println("A["+i+"]=" + ArrayA[i]);
        }
    }
}
