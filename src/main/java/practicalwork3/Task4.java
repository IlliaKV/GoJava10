package practicalwork3;

import java.util.Scanner;

public class Task4 {
    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите размер массива A: ");
        int n = in.nextInt();
        System.out.println("Введите min: ");
        int minel = in.nextInt();
        System.out.println("Введите max: ");
        int maxel = in.nextInt();

        int[] ArrayA = new int[n];

        for(int i=0; i<n;i++){
            ArrayA[i]= rnd(minel, maxel);
            System.out.println("A["+i+"]=" + ArrayA[i]);
            //ArrayA[i]=in.nextInt();
        }

        for(int i=0,max = ArrayA[i], k = 0; i<n-1;i++) {
           for (int j=i; j<n;j++) {
                if (max <= ArrayA[j]) {
                    max = ArrayA[j];
                    k = j;
                }
            }
            ArrayA[k] = ArrayA[i];
            ArrayA[i] = max;
            max = i < n ? ArrayA[i+1] : 0;
        }

        System.out.println("Mассив A отсортирован по убыванию: ");
        for(int i=0; i<n;i++){
            System.out.println("A["+i+"]=" + ArrayA[i]);
        }
    }
}
