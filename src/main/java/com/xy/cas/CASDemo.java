package com.xy.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    private static long count = 0;

    public static void main(String[] args) {

        long t1 = System.currentTimeMillis();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++){
                    count ++;
                }
            }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread2.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long t2 = System.currentTimeMillis();
        System.out.println(count);
        System.out.println(t2-t1);
    }
}
