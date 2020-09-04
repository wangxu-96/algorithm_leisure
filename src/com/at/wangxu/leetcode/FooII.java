package com.at.wangxu.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FooII {

    //使用lock condition
    final ReentrantLock lock;
    volatile int a;
    final Condition condition;

    public FooII() {
        lock = new ReentrantLock();
        condition = lock.newCondition();
        a = 1;
    }

    public void first(Runnable printFirst) throws InterruptedException {

        lock.lock();
        try {
            while (a != 1)
                condition.await();
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            a = 2;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (a != 2)
                condition.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            a = 3;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (a != 3)
                condition.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            a = 3;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        FooII foo = new FooII();
        new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third invoke"));
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
        new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first invoke"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
