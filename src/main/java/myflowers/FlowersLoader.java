package myflowers;

import myflowers.flowers.Chamomile;
import myflowers.flowers.Flower;
import myflowers.flowers.Rose;
import myflowers.flowers.Tulip;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FlowersLoader {
    public static Flower[] load(String pathToFile){
        File file = new File(pathToFile);
        Scanner scanner = null;
        Flower[] flowers = null;

        try {
            scanner = new Scanner(file);
            int countOfFlowers = scanner.nextInt();
            flowers = new Flower[countOfFlowers];
            scanner.nextLine();

            for (int i=0; i<countOfFlowers; i++){
                String nameFlower = scanner.nextLine();
                if(nameFlower.equals("роза")){
                    flowers[i] = new Rose();
                }else if(nameFlower.equals("ромашка")){
                    flowers[i] = new Chamomile();
                }else if(nameFlower.equals("тюльпан")){
                    flowers[i] = new Tulip();
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flowers;
    }
}
