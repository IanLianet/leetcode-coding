package org.ianlai.example.thread;

public class SynchronizedExample {

    public static boolean c = true;

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();

        new Thread(() -> {
            synchronized (a) {
                while (c) {
                    synchronized (b) {

                    }
                }
                System.out.println("thread1 stop");
            }
        }).start();

        Thread.sleep(1000L);

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            c = false;
            System.out.println("sleep -> false");
        }).start();
    }
}
