package practicalwork3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите размер массива A: ");
        int nA = in.nextInt();
        int[] ArrayA = new int[nA];

        for(int i=0; i<nA;i++){
            System.out.print("A["+i+"]=");
            ArrayA[i]=in.nextInt();
        }

        System.out.println("Введите размер массива B: ");
        int nB = in.nextInt();
        int[] ArrayB = new int[nB];

        for(int i=0; i<nB;i++){
            System.out.print("B["+i+"]=");
            ArrayB[i]=in.nextInt();
        }

        System.out.println("Массив C(суммы i-ых элементов массивов A i B): ");
        int nC = nA > nB ? nA: nB;
        int[] ArrayC = new int[nC];

        for(int i=0; i<nC;i++){
            int elementA = i < nA? ArrayA[i] : 0;
            int elementB = i < nB? ArrayB[i] : 0;
            ArrayC[i] = elementA + elementB;
            System.out.println("C["+i+"]=" + ArrayC[i]);
        }
    }
}
