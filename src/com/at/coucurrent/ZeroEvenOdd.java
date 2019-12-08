package com.at.coucurrent;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    private Semaphore s0,sEven,sOdd;

    public ZeroEvenOdd(int n) {
        this.n = n;
        s0 = new Semaphore(1);
        sEven = new Semaphore(0);
        sOdd = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        for (int i = 1; i <= n ; i++) {
            s0.acquire();
            printNumber.accept(0);
            if ( i % 2 == 0){
                sEven.release();
            }
            if ( i % 2 == 1){
                sOdd.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        for (int i = 2; i <= n; i+=2) {
            sEven.acquire();
            printNumber.accept(i);
            s0.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            sOdd.acquire();
            printNumber.accept(i);
            s0.release();
        }
    }

    public static void main(String[] args) {
        IntConsumer consumer = System.out::println;
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);
        new Thread(()->{
            try {
                zeroEvenOdd.zero(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                zeroEvenOdd.even(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                zeroEvenOdd.odd(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
