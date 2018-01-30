package homework4;

import java.util.Scanner;

public class AllInOne {
    //**************************************************************************************************************1
    static void outCountingToX(int X){
        for(int i=1; i<=X;i++){
            System.out.print(i+" ");
        }
    }
    static void mainCouintingToX() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число Х:");
        int X = in.nextInt();
        outCountingToX(X);
    }
    //**************************************************************************************************************2
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

    static void mainDrawRectangle() {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите ширину:");
        int width = in.nextInt();
        System.out.println("Введите высоту:");
        int height = in.nextInt();
        drawRectangle(width, height);
        System.out.println("Перегрузить функцию drawRectangle (задание 2) таким образом, чтобы она могла принимать на вход только 1 параметр (ширина квадрата) и рисовать квадрат с равными сторонами");
        drawRectangle(width);
    }
    //**************************************************************************************************************3
    static int getMax(int firstNumber, int secondNumber){
        return firstNumber < secondNumber ? secondNumber : firstNumber;
    }
    static float getMax(float firstNumber, float secondNumber){
        return firstNumber < secondNumber ? secondNumber : firstNumber;
    }

    static void mainGetMaxForIntFloat() {
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
    //**************************************************************************************************************4
    static String outCountingToXRec(int X){
        if (X<=0) return "";
        return outCountingToXRec(X-1) + " " + X;
    }

    static void mainCountingToXwithRecursion() {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите число Х:");
        int X = in.nextInt();
        System.out.println(outCountingToXRec(X));
    }
    //**************************************************************************************************************5
    static String drawRectangleRec(int width, int height, int static_w, int static_h){

        if (width == 0 && height > 1) {
            width = static_w;
            return drawRectangleRec(width, height-1, static_w, static_h) + "\n";
        }else if (width == 0 && height == 1) {
            return "";
        } else return drawRectangleRec(width-1, height, static_w, static_h) + "+";
    }

    static String drawRectangleRec(int width, int static_width, int countLines){
        if(width==0) {
            width = static_width;
            return drawRectangleRec(width, static_width, countLines-1) + "\n";
        }else if(width>0 && countLines == 0){
            return "";
        }
        else {
            return drawRectangleRec(width-1, static_width, countLines) + "+";
        }
    }

    static void mainDrawRectangleWithRecursion() {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите ширину:");
        int width = in.nextInt();
        System.out.println("Введите высоту:");
        int height = in.nextInt();
        System.out.println(drawRectangleRec(width, height, width, height));
        System.out.println("Перегрузить функцию drawRectangle (задание 2) таким образом, чтобы она могла принимать на вход только 1 параметр (ширина квадрата) и рисовать квадрат с равными сторонами");
        System.out.println(drawRectangleRec(width, width, width));
    }
    //**************************************************************************************************************main
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int chooseNumber = 1;
        do{
            System.out.println("\n\n\tМЕНЮ");
            System.out.println("1. CouintingToX");
            System.out.println("2. DrawRectangle");
            System.out.println("3. GetMaxForIntFloat");
            System.out.println("4. CountingToXwithRecursion");
            System.out.println("5. DrawRectangleWithRecursion");
            System.out.println("6. Завершить программу");
            System.out.println("Введите номер пункта который хотите выбрать...");
            chooseNumber = in.nextInt();

            switch (chooseNumber){
                case 1:{
                    mainCouintingToX();
                    break;
                }
                case 2:{
                    mainDrawRectangle();
                    break;
                }
                case 3:{
                    mainGetMaxForIntFloat();
                    break;
                }
                case 4:{
                    mainCountingToXwithRecursion();
                    break;
                }
                case 5:{
                    mainDrawRectangleWithRecursion();
                    break;
                }
                case 6:{
                    System.out.println("Выход...");
                    break;
                }
                default:{
                    System.out.println("Был не верно введен бункт меню. Попробуйте еще раз...");
                }
            }
        }while(chooseNumber!=6);
    }
}
