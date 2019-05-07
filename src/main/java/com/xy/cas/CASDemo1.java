package com.xy.cas;

public class CASDemo1 {
    private static long count = 0;

    public static void main(String[] args) {

        long t1 = System.currentTimeMillis();
        Thread thread1 = new Thread(){
            @Override
            public  void run() {
                    for(int i=0;i<100000000;i++){
                        synchronized(CASDemo1.class){
                            count ++;
                        }
                    }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                    for(int i=0;i<100000000;i++){
                        synchronized(CASDemo1.class){
                            count ++;
                        }
                    }
            }
        };
        thread1.start();
        thread2.start();
        while(thread1.isAlive() || thread2.isAlive()){
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
        System.out.println(count);
    }
}
