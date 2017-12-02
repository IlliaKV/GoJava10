package homework4;

import java.util.Scanner;

public class DrawRectangle {

    static void drawRectangle(int width, int height){
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                System.out.print("+");
            }
            System.out.print("\n");
        }
    }
    static void drawRectangle(int width){
        for(int i=0; i<width; i++){
            for(int j=0; j<width; j++){
                System.out.print("+");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите ширину:");
        int width = in.nextInt();
        System.out.println("Введите высоту:");
        int height = in.nextInt();
        drawRectangle(width, height);
        System.out.println("Перегрузить функцию drawRectangle (задание 2) таким образом, чтобы она могла принимать на вход только 1 параметр (ширина квадрата) и рисовать квадрат с равными сторонами");
        drawRectangle(width);
    }
}
