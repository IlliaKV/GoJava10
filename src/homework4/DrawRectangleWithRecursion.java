package homework4;

import java.util.Scanner;

public class DrawRectangleWithRecursion {

    static String drawRectangle(int width, int height, int static_w, int static_h){

        if (width == 0 && height > 1) {
            width = static_w;
            return drawRectangle(width, height-1, static_w, static_h) + "\n";
        }else if (width == 0 && height == 1) {
            return "";
        } else return drawRectangle(width-1, height, static_w, static_h) + "+";
    }

    static String drawRectangle(int width, int static_width, int countLines){
        if(width==0) {
            width = static_width;
            return drawRectangle(width, static_width, countLines-1) + "\n";
        }else if(width>0 && countLines == 0){
            return "";
        }
        else {
            return drawRectangle(width-1, static_width, countLines) + "+";
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите ширину:");
        int width = in.nextInt();
        System.out.println("Введите высоту:");
        int height = in.nextInt();
        System.out.println(drawRectangle(width, height, width, height));
        System.out.println("Перегрузить функцию drawRectangle (задание 2) таким образом, чтобы она могла принимать на вход только 1 параметр (ширина квадрата) и рисовать квадрат с равными сторонами");
        System.out.println(drawRectangle(width, width, width));
    }
}
