package homework4;

import java.util.Scanner;

public class GetMaxForIntFloat {

    static int getMax(int firstNumber, int secondNumber){
        return firstNumber < secondNumber ? secondNumber : firstNumber;
    }
    static float getMax(float firstNumber, float secondNumber){
        return firstNumber < secondNumber ? secondNumber : firstNumber;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите первое число:");
        float firstNumberA = in.nextFloat();
        int firstNumberB = (int)firstNumberA;

        System.out.println("Введите второе число:");
        float secondNumberA = in.nextFloat();
        int secondNumberB = (int)secondNumberA;

        System.out.println("Максимальное (int) = " + getMax(firstNumberB, secondNumberB));
        System.out.println("Максимальное (float) = " + getMax(firstNumberA, secondNumberA));
    }
}
