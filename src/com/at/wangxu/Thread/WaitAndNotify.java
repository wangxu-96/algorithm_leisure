package com.at.wangxu.Thread;

public class WaitAndNotify {

    static int i = 1;
    static final Object lock = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            while (i <= 100) {
                synchronized (lock) {
                    if (i % 2 == 1) {
                        //print odd
                        System.out.println(i + Thread.currentThread().getName());
                        i++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (i <= 100) {
                synchronized (lock) {
                    if (i % 2 == 0) {
                        //print even
                        System.out.println(i + Thread.currentThread().getName());
                        i++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }).start();
    }
}
