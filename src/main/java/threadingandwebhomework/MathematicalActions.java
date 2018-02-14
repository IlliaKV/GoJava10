package threadingandwebhomework;

import java.util.Scanner;
import java.util.concurrent.*;

public class MathematicalActions {
    public static int choiceNumber(){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice < 0  || choice > 8){
            choice = scanner.nextInt();
        }
        return choice;
    }

    public static Callable<Double> addition = new Callable<Double>(){

        @Override
        public Double call() throws Exception {
            Scanner scanner = new Scanner(System.in);
            System.out.println("input A:");
            double A = scanner.nextDouble();
            System.out.println("input B:");
            double B = scanner.nextDouble();
            return A+B;
        }
    };

    public static Callable<Double> subtraction = new Callable<Double>(){

        @Override
        public Double call() throws Exception {
            Scanner scanner = new Scanner(System.in);
            System.out.println("input A:");
            double A = scanner.nextDouble();
            System.out.println("input B:");
            double B = scanner.nextDouble();
            return A-B;
        }
    };

    public static Callable<Double> division = new Callable<Double>(){

        @Override
        public Double call() throws Exception {
            Scanner scanner = new Scanner(System.in);
            System.out.println("input A:");
            double A = scanner.nextDouble();
            System.out.println("input B:");
            double B = scanner.nextDouble();
            return A/B;
        }
    };

    public static Callable<Double> multiplication = new Callable<Double>(){

        @Override
        public Double call() throws Exception {
            Scanner scanner = new Scanner(System.in);
            System.out.println("input A:");
            double A = scanner.nextDouble();
            System.out.println("input B:");
            double B = scanner.nextDouble();
            return A*B;
        }
    };

    public static Callable<Double> fraction = new Callable<Double>(){

        @Override
        public Double call() throws Exception {
            Scanner scanner = new Scanner(System.in);
            System.out.println("input A:");
            double A = scanner.nextDouble();
            System.out.println("input B:");
            double B = scanner.nextDouble();
            return A%B;
        }
    };

    public static Callable<Boolean> equality = new Callable<Boolean>(){

        @Override
        public Boolean call() throws Exception {
            Scanner scanner = new Scanner(System.in);
            System.out.println("input A:");
            double A = scanner.nextDouble();
            System.out.println("input B:");
            double B = scanner.nextDouble();
            return A == B;
        }
    };

    public static Callable<Boolean> more = new Callable<Boolean>(){

        @Override
        public Boolean call() throws Exception {
            Scanner scanner = new Scanner(System.in);
            System.out.println("input A:");
            double A = scanner.nextDouble();
            System.out.println("input B:");
            double B = scanner.nextDouble();
            return A > B;
        }
    };

    public static Callable<Boolean> less = new Callable<Boolean>(){

        @Override
        public Boolean call() throws Exception {
            Scanner scanner = new Scanner(System.in);
            System.out.println("input A:");
            double A = scanner.nextDouble();
            System.out.println("input B:");
            double B = scanner.nextDouble();
            return A < B;
        }
    };

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<Double> future;
        Future<Boolean> futureBoolean;

        System.out.println("what to do?\n" +
                "1. +\n" +
                "2. -\n" +
                "3. *\n" +
                "4. /\n" +
                "5. %\n" +
                "6. ==\n" +
                "7. >\n" +
                "8. <\n" +
                "0. exit");

        int choice = -1;
        while (true) {
            choice = choiceNumber();
            switch (choice) {
                case 1: {
                    future = service.submit(addition);
                    System.out.println("A + B = " + future.get());
                    break;
                }
                case 2: {
                    future = service.submit(subtraction);
                    System.out.println("A - B = " + future.get());
                    break;
                }
                case 3: {
                    future = service.submit(multiplication);
                    System.out.println("A * B = " + future.get());
                    break;
                }
                case 4: {
                    future = service.submit(division);
                    System.out.println("A / B = " + future.get());
                    break;
                }
                case 5: {
                    future = service.submit(fraction);
                    System.out.println("A % B = " + future.get());
                    break;
                }
                case 6: {
                    futureBoolean = service.submit(equality);
                    System.out.println("A == B = " + futureBoolean.get());
                    break;
                }
                case 7: {
                    futureBoolean = service.submit(more);
                    System.out.println("A > B = " + futureBoolean.get());
                    break;
                }
                case 8: {
                    futureBoolean = service.submit(less);
                    System.out.println("A < B = " + futureBoolean.get());
                    break;
                }
                case 0: {
                    service.shutdown();
                    System.exit(1);
                }
            }
        }
    }
}
