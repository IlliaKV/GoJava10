package practicalwork3;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите ширину: ");
        int width = in.nextInt();
        System.out.println("Введите высоту: ");
        int height = in.nextInt();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print("+");
            }
            System.out.println("");
        }
    }
}
