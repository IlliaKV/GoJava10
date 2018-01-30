package jsonpracticalwork.lines;

import com.alibaba.fastjson.JSON;
import jsonpracticalwork.LoadFile;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String file = null;
        try {
            file = LoadFile.readUsingScanner("Files/JSONs/1_1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(file);

//        ArrayList<String> linesArray = new ArrayList<>();
//        linesArray.add("first");
//        linesArray.add("second");
//        linesArray.add("third");
//
//        Lines lines = new Lines(linesArray);
//
//        String jsonLines = JSON.toJSONString(lines);
//
//        System.out.println(jsonLines);

        Lines lines = JSON.parseObject(file, Lines.class);
        System.out.println(lines);
    }
}
