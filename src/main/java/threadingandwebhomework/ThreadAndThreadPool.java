package threadingandwebhomework;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadAndThreadPool {
    public static double sumThreadMode = 0;
    public static void threadMode(int N) throws InterruptedException {
        int size = 80000000;
        double[] theyAreBillions = new double[size];
        for (int i = 0; i < N; i++){
            theyAreBillions[i] = i+1;
        }
        double step = size/N;
        Thread[] threads = new Thread[N];

        for (int i = 0; i < N; i++){
            final int firstElements = (int)(i * step);
            final int lastElements = (int)(firstElements + step);
            Runnable runnable = () -> {
                for (int j = firstElements; j < lastElements; j++){
                    sumThreadMode += Math.sin(theyAreBillions[j]) + Math.cos(theyAreBillions[j]);
                }
            };
            threads[i] = new Thread(runnable);
            threads[i].start();
        }

        for (int i = 0; i < N; i++){
            threads[i].join();
        }

        System.out.println("sumThreadMode = " + sumThreadMode);
    }

    public static void threadPoolMode(int N) throws ExecutionException, InterruptedException {
        int size = 80000000;
        double[] theyAreBillions = new double[size];
        for (int i = 0; i < N; i++){
            theyAreBillions[i] = i+1;
        }

        ExecutorService threadPool  = Executors.newFixedThreadPool(N);
        Future<Double> future;

        double sumThreadPoolMode = 0;
        for (int i = 0; i < size; i++){
            final int x = i;
            Callable<Double> operation = () -> Math.sin(theyAreBillions[x]) + Math.cos(theyAreBillions[x]);
            future = threadPool.submit(operation);
            sumThreadPoolMode += future.get();
        }

        System.out.println("sumThreadPoolMode = " + sumThreadPoolMode);
        threadPool.shutdown();
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long timeStart;
        long timeEnd;
        Scanner scanner = new Scanner(System.in);
        System.out.println("input number of counting:");
        final int N = scanner.nextInt();



        timeStart = System.currentTimeMillis();
        System.out.println("start Thread mode");
        //threadMode(N);
        timeEnd = System.currentTimeMillis();
        System.out.println("working time in Thread mode: " + (timeEnd - timeStart));

        timeStart = System.currentTimeMillis();
        System.out.println("start Thread Pool mode");
        threadPoolMode(N);
        timeEnd = System.currentTimeMillis();
        System.out.println("working time in Thread Pool mode: " + (timeEnd - timeStart));
    }
}
