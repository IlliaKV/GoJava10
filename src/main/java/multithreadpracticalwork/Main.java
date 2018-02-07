package multithreadpracticalwork;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public final static int NUMBER_OF_CORE = Runtime.getRuntime().availableProcessors();

    public static ArrayList<Integer> getArray(){
        ArrayList<Integer> arrayList = new ArrayList<>();

        String datafile = null;
        try {
            File file = new File("Files/JSONs/10 000 000 Numbers.txt");
            Scanner scanner = new Scanner(file);
            datafile = scanner.useDelimiter("\\Z").next();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        arrayList = JSON.parseObject(datafile, new TypeReference<ArrayList<Integer>>(){});
        return arrayList;
    }

    public static void getSum(ArrayList<Integer> arrayList){
        long arraySum1 = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++){
            arraySum1 += arrayList.get(i);
        }
        System.out.println("array Sum without using threads: " + arraySum1);
    }

    public static void getMultiplication(ArrayList<Integer> arrayList){
        long arrayMult = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++){
            arrayMult *= arrayList.get(i);
        }
        System.out.println("array Multiplication without using threads: " + arrayMult);
    }

    public static void getDivsionOnIndexMinusOneAndSum(ArrayList<Integer> arrayList){
        long arraySum = 0;
        for (int i = 0; i < arrayList.size(); i++){
            arraySum += arrayList.get(i)/(i+1);
        }
        System.out.println("array DivsionOnIndexMinusOneAndSum without using threads: " + arraySum);
    }

    public static void getDistinction(ArrayList<Integer> arrayList){
        long arrayDistinction = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++){
            arrayDistinction -= arrayList.get(i);
        }
        System.out.println("array Distinction without using threads: " + arrayDistinction);
    }

    static long[] arraySums = new long[NUMBER_OF_CORE];

    public static void getSumUsingThrads(ArrayList<Integer> arrayList) throws InterruptedException {

        for (int as = 0; as < NUMBER_OF_CORE; as++){
            arraySums[as] = 0;
        }

        int step = arrayList.size()/NUMBER_OF_CORE;

        Thread[] threads = new Thread[NUMBER_OF_CORE];
        for (int i = 0; i < NUMBER_OF_CORE; i++){
            final int ii = i;
            final int firstElements = i * step;
            final int lastElements = firstElements + step;

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    for (int j = firstElements; j < lastElements; j++){
                        arraySums[ii] += arrayList.get(j);
                    }
                }
            };
            threads[i] = new Thread(runnable);
            threads[i].start();
        }

        for (int i = 0; i < NUMBER_OF_CORE; i++){
            threads[i].join();
        }

        long arraySum = 0;
        for (int i = 0; i < NUMBER_OF_CORE; i++){
            arraySum += arraySums[i];
        }
        System.out.println("array Sum with using threads: " + arraySum);
    }

    public static void main(String[] args) throws InterruptedException {
        long timeStart;
        long timeEnd;

        timeStart = System.currentTimeMillis();
        ArrayList<Integer> arrayList = getArray();
        timeEnd = System.currentTimeMillis();
        System.out.println("working time: " + (timeEnd - timeStart));



        timeStart = System.currentTimeMillis();
        getSum(arrayList);
        timeEnd = System.currentTimeMillis();
        System.out.println("working time: " + (timeEnd - timeStart));
//
//        timeStart = System.currentTimeMillis();
//        getMultiplication(arrayList);
//        timeEnd = System.currentTimeMillis();
//        System.out.println("working time: " + (timeEnd - timeStart));
//
//        timeStart = System.currentTimeMillis();
//        getDivsionOnIndexMinusOneAndSum(arrayList);
//        timeEnd = System.currentTimeMillis();
//        System.out.println("working time: " + (timeEnd - timeStart));
//
//        timeStart = System.currentTimeMillis();
//        getDistinction(arrayList);
//        timeEnd = System.currentTimeMillis();
//        System.out.println("working time: " + (timeEnd - timeStart));

        timeStart = System.currentTimeMillis();
        getSumUsingThrads(arrayList);
        timeEnd = System.currentTimeMillis();
        System.out.println("working time: " + (timeEnd - timeStart));

    }
}
