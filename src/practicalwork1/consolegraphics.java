package practicalwork1;
import java.util.Scanner;

public class consolegraphics {
    public static void drawLine(int x, char c){
        for(int i=0;i<x;i++)
        System.out.print(c);
    }
    public static char queryChar(){
        System.out.print("Введите символ: ");
        Scanner in = new Scanner(System.in);
        char c = in.nextLine().charAt(0);;
        return c;
    }
    public static void main(String[] args) {
        char symbol = queryChar();
        drawLine(5, symbol);
    }
}
