package homework2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Ваше имя?");
        String name = in.nextLine();
        System.out.println("Ваш город?");
        String city = in.nextLine();
        System.out.println("Ваш возраст?");
        int age = in.nextInt();
        System.out.println("Ваше хобби?");
        String hobby = in.next();

        System.out.println("----------------------------------\n" +
                "Вариант 1 (табличный):\n" +
                "Имя:\t\t"+name+"\n" +
                "Город:\t\t"+city+"\n" +
                "Возраст:\t"+age+"\n" +
                "Хобби:\t\t"+hobby+"\n" +
                "----------------------------------\n" +
                "Вариант 2 (текстовый):\n" +
                "Человек по имени "+name+" живет в городе "+city+".\n" +
                "Этому человеку "+age+" лет и любит он заниматься "+hobby+".\n" +
                "----------------------------------\n" +
                "Вариант 3 (иной):\n" +
                name+"\t - имя\n" +
                city+"\t - город\n" +
                age+"\t - возраст\n" +
                hobby+"\t - хобби\n" +
                "----------------------------------");

    }
}
