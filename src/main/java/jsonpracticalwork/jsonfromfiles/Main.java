package jsonpracticalwork.jsonfromfiles;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import jsonpracticalwork.LoadFile;

import java.io.IOException;

public class Main {

    public static void parseToData(String json, TypeReference typeRef){
        //TypeReference<Data<String, Integer>> typeRef = new TypeReference<Data<String, Integer>>() {};
        Object modelData = JSON.parseObject(json, typeRef);
        System.out.println(modelData);
    }
    public static void main(String[] args) {
        String file_3_1 = null;
        String file_3_2 = null;
        String file_3_3 = null;
        String file_3_4 = null;
        try {
            file_3_1 = LoadFile.readUsingScanner("Files/JSONs/3_1.txt");
            file_3_2 = LoadFile.readUsingScanner("Files/JSONs/3_2.txt");
            file_3_3 = LoadFile.readUsingScanner("Files/JSONs/3_3.txt");
            file_3_4 = LoadFile.readUsingScanner("Files/JSONs/3_4.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(file_3_1);

        //Data<String, Integer> datas = JSON.parseObject(file_3_1, Data<String, Integer>.class);
        parseToData(file_3_1, new TypeReference<Data<String, Integer>>() {});
        parseToData(file_3_2, new TypeReference<Data<Integer, String>>() {});
        parseToData(file_3_3, new TypeReference<Data<String, String>>() {});
        parseToData(file_3_4, new TypeReference<Data<Integer, Integer>>() {});


    }
}
