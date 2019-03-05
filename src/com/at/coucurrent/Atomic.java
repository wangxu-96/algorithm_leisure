package com.at.coucurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {
    public static void main(String[] args){
        Thread[] threads = new Thread[20];
        MyAtomicInteger atomicInteger = new MyAtomicInteger();
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    atomicInteger.increment(1);
                } 
            });
            threads[i].start();
        }
        join(threads);
        System.out.println("x=: "+atomicInteger.get());
    }

    private static void join(Thread[] threads) {
        for (int i = 0; i < 20; i++) {
            try {
                threads[i].join();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
