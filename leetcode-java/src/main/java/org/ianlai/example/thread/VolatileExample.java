package org.ianlai.example.thread;

/**
 * @author ianlianetlai
 */
public class VolatileExample {

    private static volatile int a = 0;
    private static int b = 0;

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 10000; j++) {
//                    if (b == b) {
//                        synchronized (VolatileExample.class){
//                            b++;
//                            a++;
//                        }
//                        b++;
//                        a++;

                    synchronized (VolatileExample.class) {
                        if (b == b) {
                            b++;
                            a++;
                        }
                    }

                    //System.out.println(a);
                }
            }

    };

    Thread thread1 = new Thread(runnable, 1 + "Thread");
    Thread thread2 = new Thread(runnable, 2 + "Thread");
        thread1.start();
        thread2.start();
        while(thread1.isAlive()||thread2.isAlive())

    {
    }
        System.out.println("end:a:"+a +";b:"+b);
}
}
