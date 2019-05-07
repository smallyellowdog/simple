package com.xy.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo3 {
    private static AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                for(int i=0;i<100000000;i++){
                    count.incrementAndGet();
                }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                for(int i=0;i<100000000;i++){
                    count.incrementAndGet();
                }
            }
        };

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
        System.out.println(count);
    }
}
