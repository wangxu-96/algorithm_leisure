package com.at.wangxu.leetcode;

import java.util.concurrent.Semaphore;

public class FooIV {
    Semaphore semaphoreSecond;
    Semaphore semaphoreThird;

    public FooIV() {
        semaphoreSecond = new Semaphore(0);
        semaphoreThird = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphoreSecond.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphoreSecond.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphoreThird.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphoreThird.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) {
        FooIV foo = new FooIV();
        new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third invoke"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first invoke"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second invoke"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
