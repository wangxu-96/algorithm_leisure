package com.at.wangxu.leetcode;

public class FooIII {

    private volatile int nextThread;

    public FooIII() {
        nextThread = 1;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (nextThread != 1) {
            //Thread.sleep(1);
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        nextThread = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (nextThread != 2) {
            //Thread.sleep(1);
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        nextThread = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (nextThread != 3) {
            //Thread.sleep(1);
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        nextThread = -1;
    }

    public static void main(String[] args) {
        FooIII foo = new FooIII();
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
