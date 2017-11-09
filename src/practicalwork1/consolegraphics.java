package practicalwork1;
import java.util.Scanner;

public class consolegraphics {

    public static void drawLine(int x, char c){
        for(int i=0;i<x;i++)
        System.out.print(c);
    }
    public static char inputC(){
        System.out.print("Введите символ: ");
        Scanner in = new Scanner(System.in);
        char c = in.nextLine().charAt(0);
        return c;
    }
    public static int inputX(){
        System.out.print("Введите целое число: ");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        return x;
    }
    public static void main(String[] args) {
        char c = inputC();
        int x = inputX();
        drawLine(x, c);
	}
    public static void drawrect (int y, char c)
    {
        for (int i = 0; i < y; i++) {
            System.out.println ("########");

        }

    }

}


        


