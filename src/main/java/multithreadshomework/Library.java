package multithreadshomework;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class Library {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("input peopleCount: ");
        final int peopleCount = scanner.nextInt();

        System.out.println("input maxAmount: ");
        final int maxAmount = scanner.nextInt();


        Thread[] threads          = new Thread[peopleCount];
        boolean[] readingPlaces   = new boolean[maxAmount];
        final Semaphore semaphore = new Semaphore(maxAmount, true);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                long threadId = Thread.currentThread().getId();
                System.out.println(threadId + " пришел ко входу в библиотеку");

                if (semaphore.getQueueLength() > 0) {
                    System.out.println(threadId + " ждет входа в библиотеку");
                }

                try {
                    semaphore.acquire();

                    Random rn = new Random();
                    int timeReading = rn.nextInt(5 - 1 + 1) + 1;
                    int readingNumber = -1;

                    synchronized (readingPlaces){
                        for (int i = 0; i < maxAmount; i++)
                            if (!readingPlaces[i]) {            //Если место свободно
                                readingPlaces[i] = true;        //занимаем его
                                readingNumber = i;              //Наличие свободного места, гарантирует семафор

                                System.out.println(threadId + " подошел к двери с улицы");
                                System.out.println(threadId + " проходит через дверь внутрь");
                                Thread.sleep(500);
                                System.out.println(threadId + " прошел через дверь внутрь");

                                System.out.println(threadId + " вошел в библиотеку");
                                break;
                            }
                    }

                    System.out.println(threadId + " читает книгу " + timeReading + "c");
                    Thread.sleep(timeReading * 1000);

                    synchronized (readingPlaces) {
                        readingPlaces[readingNumber] = false;   //Освобождаем место

                        System.out.println(threadId + " подошел к двери изнутри");
                        System.out.println(threadId + " проходит через через дверь наружу");
                        Thread.sleep(500);
                        System.out.println(threadId + " прошел через дверь наружу");

                    }

                    System.out.println(threadId + " вышел из библиотеки");
                    semaphore.release();                        //release(), напротив, освобождает ресурс
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < peopleCount; i++){
            threads[i] = new Thread(runnable);
            threads[i].start();
        }
    }
}
