package fruitstorejsonhomework;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TradeShop {
    public ArrayList<Fruit> fruits;

    public TradeShop() {
        fruits = new ArrayList<>();
    }

    public TradeShop(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }

    public void addFruits(String pathToJsonFile) throws IOException {
        ArrayList<Fruit> fruitsForAdd = new ArrayList<>();

        File file = new File(pathToJsonFile);
        Scanner scanner = new Scanner(file);
        String data = scanner.useDelimiter("\\Z").next();
        scanner.close();

        TradeShop tradeShopForAdd = new TradeShop(fruitsForAdd);
        tradeShopForAdd = JSON.parseObject(data, TradeShop.class);

        fruits.addAll(tradeShopForAdd.fruits);
    }

    public void save(String pathToJsonFile){

        String jsonText = JSON.toJSONString(this);;

        File file = new File(pathToJsonFile);
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(pathToJsonFile);

            fileWriter.write(jsonText);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void load(String pathToJsonFile) throws IOException{
        File file = new File(pathToJsonFile);
        Scanner scanner = new Scanner(file);
        String data = scanner.useDelimiter("\\Z").next();
        scanner.close();

        TradeShop tradeShopForLoad = new TradeShop();
        tradeShopForLoad = JSON.parseObject(data, TradeShop.class);
        fruits = tradeShopForLoad.fruits;
    }

    public ArrayList<Fruit> getSpoiledFruits(Date date){
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Fruit> fruitArrayList = new ArrayList<>();

        for (int i = 0; i < fruits.size(); i++){
            String dateOfDeliveryStr = fruits.get(i).date;
            Date dateOfDelivery = null;
            try{
                dateOfDelivery = format.parse(dateOfDeliveryStr);

                Calendar c = Calendar.getInstance();
                c.setTime(dateOfDelivery);
                c.add(Calendar.DATE, fruits.get(i).shelfLife);
                dateOfDelivery = c.getTime();

                if(date.after(dateOfDelivery)){
                    fruitArrayList.add(fruits.get(i));
                }
            }
            catch ( Exception ex ){
                System.out.println(ex);
            }
        }

        return fruitArrayList;
    }

    public ArrayList<Fruit> getAvailableFruits(Date date){
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Fruit> fruitArrayList = new ArrayList<>();

        for (int i = 0; i < fruits.size(); i++){
            String dateOfDeliveryStr = fruits.get(i).date;
            Date dateOfDelivery = null;
            try{
                dateOfDelivery = format.parse(dateOfDeliveryStr);

                Calendar c = Calendar.getInstance();
                c.setTime(dateOfDelivery);
                c.add(Calendar.DATE, fruits.get(i).shelfLife);
                dateOfDelivery = c.getTime();

                if(date.before(dateOfDelivery)){
                    fruitArrayList.add(fruits.get(i));
                }
            }
            catch ( Exception ex ){
                System.out.println(ex);
            }
        }

        return fruitArrayList;
    }

    public ArrayList<Fruit> getSpoiledFruits(Date date, TypeFruit type){
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Fruit> fruitArrayList = new ArrayList<>();

        for (int i = 0; i < fruits.size(); i++){
            String dateOfDeliveryStr = fruits.get(i).date;
            Date dateOfDelivery = null;
            if(fruits.get(i).type == type){
                try{
                    dateOfDelivery = format.parse(dateOfDeliveryStr);

                    Calendar c = Calendar.getInstance();
                    c.setTime(dateOfDelivery);
                    c.add(Calendar.DATE, fruits.get(i).shelfLife);
                    dateOfDelivery = c.getTime();

                    if(date.after(dateOfDelivery)){
                        fruitArrayList.add(fruits.get(i));
                    }
                }
                catch ( Exception ex ){
                    System.out.println(ex);
                }
            }
        }

        return fruitArrayList;
    }

    public ArrayList<Fruit> getAvailableFruits(Date date, TypeFruit type){
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Fruit> fruitArrayList = new ArrayList<>();

        for (int i = 0; i < fruits.size(); i++){
            String dateOfDeliveryStr = fruits.get(i).date;
            Date dateOfDelivery = null;
            if(fruits.get(i).type == type) {
                try {
                    dateOfDelivery = format.parse(dateOfDeliveryStr);

                    Calendar c = Calendar.getInstance();
                    c.setTime(dateOfDelivery);
                    c.add(Calendar.DATE, fruits.get(i).shelfLife);
                    dateOfDelivery = c.getTime();

                    if (date.before(dateOfDelivery)) {
                        fruitArrayList.add(fruits.get(i));
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }

        return fruitArrayList;
    }

    public ArrayList<Fruit> getAddedFruits(Date date){
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Fruit> fruitArrayList = new ArrayList<>();

        for (int i = 0; i < fruits.size(); i++){
            String dateOfDeliveryStr = fruits.get(i).date;
            Date dateOfDelivery = null;
            try{
                dateOfDelivery = format.parse(dateOfDeliveryStr);
                if(date.compareTo(dateOfDelivery) == 0){
                    fruitArrayList.add(fruits.get(i));
                }
            }
            catch ( Exception ex ){
                System.out.println(ex);
            }
        }

        return fruitArrayList;
    }

    public ArrayList<Fruit> getAddedFruits(Date date, TypeFruit type){
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Fruit> fruitArrayList = new ArrayList<>();

        for (int i = 0; i < fruits.size(); i++){
            String dateOfDeliveryStr = fruits.get(i).date;
            Date dateOfDelivery = null;
            if(fruits.get(i).type == type) {
                try {
                    dateOfDelivery = format.parse(dateOfDeliveryStr);
                    if (date.compareTo(dateOfDelivery) == 0) {
                        fruitArrayList.add(fruits.get(i));
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }

        return fruitArrayList;
    }

    @Override
    public String toString() {
        return "{" +
                "fruits=" + fruits +
                '}';
    }
}
