package jsonpracticalwork.stores;

import com.alibaba.fastjson.JSON;
import jsonpracticalwork.LoadFile;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String file = null;
        try {
            file = LoadFile.readUsingScanner("Files/JSONs/2_1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(file);

        ArrayList<ProductFruit> productFruitArrayList = new ArrayList<>();
        productFruitArrayList.add(new ProductFruit("apple", 10, 1));
        productFruitArrayList.add(new ProductFruit("banana", 20, 1));
        Store<ProductFruit> productFruitStore = new Store<>("first Store", "address first Store", productFruitArrayList);

        ArrayList<ProductTech> productTechArrayList = new ArrayList<>();
        productTechArrayList.add(new ProductTech("phone", 100, "descriprion", 60));
        productTechArrayList.add(new ProductTech("notebook", 200, "descriprionNotebook", 90));
        Store<ProductTech> productTechStore = new Store<>("second Store", "address second Store", productTechArrayList);

        ArrayList<ProductAnimal> productAnimalArrayList = new ArrayList<>();
        productAnimalArrayList.add(new ProductAnimal("cat", 50, 1));
        productAnimalArrayList.add(new ProductAnimal("dog", 60, 2));
        Store<ProductAnimal> productAnimalStore = new Store<>("second Store", "address second Store", productAnimalArrayList);


        //Stores stores = new Stores(productFruitStore, productTechStore, productAnimalStore);

        //System.out.println(stores);
//        String json = JSON.toJSONString(stores);
//        System.out.println(json);
        Stores stores = JSON.parseObject(file, Stores.class);
        System.out.println(stores);
    }
}
