package myflowers;

import myflowers.flowers.Chamomile;
import myflowers.flowers.Flower;
import myflowers.flowers.Rose;
import myflowers.flowers.Tulip;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FlowersSaver {
    public static void save(String pathToFile, Flower[] flowers){
        File file = new File(pathToFile);
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(pathToFile);
            String text = Integer.toString(flowers.length) + "\n";
            for (int i=0; i<flowers.length; i++){
                text += flowers[i].name + "\n";
            }

            fileWriter.write(text);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
