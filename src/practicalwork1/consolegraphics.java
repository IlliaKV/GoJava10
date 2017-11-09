package practicalwork1;
import java.util.Scanner;

public class consolegraphics {

    public static void drawLine(int x, char c, int color){
        String ANSI_RESET = "\u001B[0m";
        for(int i=0;i<x;i++)
        System.out.print((char) 27 + "[" + color + "m" + c + ANSI_RESET);
    }
    public static char inputC(){
        System.out.print("Введите символ: ");
        Scanner in = new Scanner(System.in);
        char c = in.nextLine().charAt(0);
        return c;
    }
    public static int inputX(){
        System.out.print("Введите целое число(для цвета 30-31): ");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        return x;
    }
    public static void main(String[] args) {
        char c = inputC();
        int x = inputX();
        int y = inputX();
        int color = inputX();
        drawrect(x,y, c, color);
	}
    public static void drawrect (int x,int y, char c, int color)
    {
        for (int i = 0; i < y; i++) {
            drawLine(x,c, color);
            System.out.println();

        }
    }
}


        


