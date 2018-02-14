package multithreadpracticalwork.task1;

public class Main {
//    final static long mainThreadId = Thread.currentThread().getId();
//
//    private static boolean isThreadMain(Thread thread) {
//        if (thread.getId()== mainThreadId) return true;
//        return false;
//    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            System.out.println("Thread name: "+Thread.currentThread().getName());
            System.out.println("Thread ID: "+Thread.currentThread().getId());

//            System.out.println("Thread is websitedownloaderFXwindow=" + isThreadMain(Thread.currentThread())+"\n");

            if(Thread.currentThread().getName().equals("websitedownloaderFXwindow"))
                System.out.println("it is websitedownloaderFXwindow thread");
            else System.out.println("it is not websitedownloaderFXwindow thread");

            System.out.println("");
        };

        Thread thread1 = new Thread(runnable);
        thread1.start();
        thread1.join();


        Thread thread2 = new Thread(runnable);
        thread2.start();
        thread2.join();

        Thread thread3 = new Thread(runnable);
        thread3.start();
        thread3.join();

        runnable.run();
    }
}
