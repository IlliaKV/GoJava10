package practicalwork4;

import java.util.Scanner;

public class Task1 {

    static int inputArrayOutIndex(int[] array){
        int index = -1;
        int maxElementOfArray = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (maxElementOfArray < array[i]){
                maxElementOfArray = array[i];
                index = i;
            }
        }

        return index;
    }

    static int outMaxAcrossIndex(int[] array){
        int maxElementOfArray = array[inputArrayOutIndex(array)];
        return maxElementOfArray;
    }

//    Написать функцию которая принимает на вход массив чисел и возвращает индекс максимального числа.
//    Написать функцию которая принимает на вход массив чисел и возвращает максимальное число, используя первую функцию.

    public static void main(String[] args) {
        int maxOfArray = Integer.MIN_VALUE;

        Scanner in = new Scanner(System.in);
        System.out.println("Введите масив через пробел:");
        String str = in.nextLine();

        String[] stringArray = str.split(" ");
        int arraySize = stringArray.length;
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = Integer.parseInt(stringArray[i]);
        }

        System.out.println("Максимальный елемент " + outMaxAcrossIndex(array) + " под индексом " + inputArrayOutIndex(array));
    }
}
