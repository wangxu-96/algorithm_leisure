package com.at.wangxu.Thread;

/**
 * 三个Thread
 * Thread1 print 1，2，3
 * Thread2 print 4，5，6
 * Thread3 print 7，8，9
 * 依此类推，直到100
 */
public class PrintThread {

    //总数
    static int count = 1;
    //锁
    static final Object lock = new Object();
    //下一个执行线程
    static int nextThread = 1;

    public static void main(String[] args) {
        new Thread(() -> {

            synchronized (lock) {
                while (count <= 100) {
                    if (nextThread == 1) {
                        print();
                        nextThread = 2;
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
        }, "Thread-1").start();
        new Thread(() -> {

            synchronized (lock) {
                while (count <= 100) {
                    if (nextThread == 2) {
                        print();
                        nextThread = 3;
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
        }, "Thread-2").start();
        new Thread(() -> {

            synchronized (lock) {
                while (count <= 100) {
                    if (nextThread == 3) {
                        print();
                        nextThread = 1;
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
        }, "Thread-3").start();
    }

    static void print() {
        int i = 0;
        do {
            System.out.println(count + "----" + Thread.currentThread().getName());
            i++;
            count++;
        } while (i < 3 && count <= 100);
    }
}
