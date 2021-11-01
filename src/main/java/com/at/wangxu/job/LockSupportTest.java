package com.at.wangxu.job;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.LockSupport;

class LockSupportTest {

    private static final int TIMES = 300000;
    private static Thread thread0, thread1, thread2;

    static LongAdder counter = new LongAdder();

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch cdl = new CountDownLatch(3);

        thread0 = new Thread(() -> {
            for (int i = 0; i < TIMES; i++) {
                counter.increment();
                // System.out.println(counter + "-" + Thread.currentThread().getName());
                LockSupport.unpark(thread1);
                LockSupport.park();
            }
            cdl.countDown();
        }, "t0");
        thread1 = new Thread(() -> {
            for (int i = 0; i < TIMES; i++) {
                // 先阻塞等待被唤醒
                LockSupport.park();
                counter.increment();
                // System.out.println(counter + "-" + Thread.currentThread().getName());
                LockSupport.unpark(thread2);
            }
            cdl.countDown();
        }, "t1");
        thread2 = new Thread(() -> {
            for (int i = 0; i < TIMES; i++) {
                // 先阻塞等待被唤醒
                LockSupport.park();
                counter.increment();
                // System.out.println(counter + "-" + Thread.currentThread().getName());
                // 唤醒下一个线程
                LockSupport.unpark(thread0);
            }
            cdl.countDown();
        }, "t2");

        long start = System.currentTimeMillis();
        System.out.println(start);

        thread0.start();
        thread1.start();
        thread2.start();
        cdl.await();

        long end = System.currentTimeMillis();
        System.out.println(end);

        System.out.println("cost: " + (end - start));
        System.out.println(counter.longValue());
    }
}
