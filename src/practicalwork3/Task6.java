package practicalwork3;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите ширину: ");
        int width = in.nextInt();
        System.out.println("Введите высоту: ");
        int height = in.nextInt();

        for (int i = 0, k = 0, symbolOut = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(i==0 || j ==0 || i==height-1 || j ==width-1){
                    symbolOut = -100;
                }else {
                    symbolOut = 1000+k++;
                }
                System.out.print(symbolOut + "\t");
            }
            System.out.println("");
        }
    }
}
