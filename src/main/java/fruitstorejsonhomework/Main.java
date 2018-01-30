package fruitstorejsonhomework;

import com.alibaba.fastjson.JSON;
import jsonpracticalwork.LoadFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit(TypeFruit.Pear, 12, "11/01/2018", 80));
        fruits.add(new Fruit(TypeFruit.Mandarin, 15, "12/01/2018", 75));
        fruits.add(new Fruit(TypeFruit.Blackberry, 9, "13/01/2018", 40));

        TradeShop tradeShop = new TradeShop(fruits);
        System.out.println("create store with default fruit:");
        System.out.println(tradeShop);

        tradeShop.save("Files/fruitstorejsonfile/storesave.txt");

        System.out.println("add fruit from supply file:");
        try {
            tradeShop.addFruits("Files/fruitstorejsonfile/supply");
        } catch (IOException e) { e.printStackTrace(); }
        System.out.println(tradeShop);

        System.out.println("getSpoiledFruits:");
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        try{ date = format.parse("25/01/2018"); } catch ( Exception ex ){ System.out.println(ex); }
        System.out.println(tradeShop.getSpoiledFruits(date));

        System.out.println("getAvailableFruits:");
        System.out.println(tradeShop.getAvailableFruits(date));

        System.out.println("getSpoiledFruits:");
        System.out.println(tradeShop.getSpoiledFruits(date, TypeFruit.Pear));

        System.out.println("getAvailableFruits:");
        System.out.println(tradeShop.getAvailableFruits(date, TypeFruit.Mandarin));

        System.out.println("getAddedFruits in same date:");
        Date date2 = new Date();
        try{ date2 = format.parse("13/01/2018"); } catch ( Exception ex ){ System.out.println(ex); }
        System.out.println(tradeShop.getAddedFruits(date2));

        System.out.println("getAddedFruits in same date and some fruit:");
        System.out.println(tradeShop.getAddedFruits(date2, TypeFruit.Blackberry));

        System.out.println("load from file:");
        try {
            tradeShop.load("Files/fruitstorejsonfile/supply");
        } catch (IOException e) { e.printStackTrace(); }
        System.out.println(tradeShop);
    }
}
