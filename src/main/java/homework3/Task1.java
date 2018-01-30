package homework3;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите размер массива:");
        int arraySize = in.nextInt();
        System.out.println("Введите числа массива:");
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            System.out.print("array[" + i + "]=");
            array[i] = in.nextInt();
        }

        int minOfArray = array[0];
        int maxOfArray = array[0];
        int counterForNumberOfFive = 0;
        for (int i = 1; i < arraySize; i++) {
            if (minOfArray > array[i]) minOfArray = array[i];
            if (maxOfArray < array[i]) maxOfArray = array[i];
            if (array[i] == 5) counterForNumberOfFive++;
        }
        System.out.println("Найменьшее число массива = " + minOfArray);
        System.out.println("Найбольшее число массива =" + maxOfArray);
        System.out.println("Количество повторений числа 5 = " + counterForNumberOfFive);

        for(int i=0,max = array[i], k = 0; i<arraySize-1;i++) {
            for (int j=i; j<arraySize;j++) {
                if (max <= array[j]) {
                    max = array[j];
                    k = j;
                }
            }
            array[k] = array[i];
            array[i] = max;
            max = i < arraySize ? array[i+1] : 0;
        }

        System.out.println("Mассив отсортирован по убыванию: ");
        for(int i=0; i<arraySize;i++){
            System.out.println("array["+i+"]=" + array[i]);
        }
    }
}
