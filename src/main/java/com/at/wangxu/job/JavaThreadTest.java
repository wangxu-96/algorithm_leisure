package com.at.wangxu.job;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class JavaThreadTest {
    private static final int MAX = 3;
    private static final int OVER = 300_000;
    private static final long SLEEP_SUB = 30;
    private static final long SLEEP_MAIN = 2000;

    private static int count = 0;
    private static Object lock = new Object();

    static class ObjectThread extends Thread {

        private int index;

        public ObjectThread(int _index) {
            this.index = _index;
            super.setName("Thread-" + index);
        }

        @Override
        public void run() {
            try {
                synchronized (lock) {
                    while (count < OVER) {
                        if (count % MAX == index) {
                            System.out.println(ObjectThread.class.getSimpleName() + "-" + Thread.currentThread().getName() + ", count=" + (count++));
                            lock.notifyAll();
                        }
                        lock.wait();
                        Thread.sleep(SLEEP_SUB);
                    }
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    private static volatile int countVolatile = 0;

    static class VolatileThread extends Thread {

        private int index;

        public VolatileThread(int _index) {
            this.index = _index;
            super.setName("Thread-" + index);
        }

        @Override
        public void run() {
            try {
                while (countVolatile < OVER) {
                    synchronized (VolatileThread.class) {
                        if (countVolatile % MAX == index) {
                            System.out.println(VolatileThread.class.getSimpleName() + "-" + Thread.currentThread().getName() + ", count=" + (countVolatile++));
                        }
                    }
                    Thread.sleep(SLEEP_SUB);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    private static AtomicInteger countAtomic = new AtomicInteger(0);

    static class AtomicThread extends Thread {

        private int index;

        public AtomicThread(int _index) {
            this.index = _index;
            super.setName("Thread-" + index);
        }

        @Override
        public void run() {
            try {
                while (countAtomic.get() < OVER) {
                    if (countAtomic.get() % MAX == index) {
                        System.out.println(AtomicThread.class.getSimpleName() + "-" + Thread.currentThread().getName() + ", count=" + (countAtomic.getAndIncrement()));
                    }
                    Thread.sleep(SLEEP_SUB);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    private static int countReentrantLock = 0;
    private static ReentrantLock reentrantLock = new ReentrantLock();

    static class ReentrantLockThread extends Thread {
        private int index;

        public ReentrantLockThread(int _index) {
            this.index = _index;
            super.setName("Thread-" + index);
        }

        @Override
        public void run() {
            while (countReentrantLock < OVER) {
                reentrantLock.lock();
                if (countReentrantLock % MAX == index) {
                    System.out.println(ReentrantLockThread.class.getSimpleName() + "-" + Thread.currentThread().getName() + ", count=" + (countReentrantLock++));
                }
                reentrantLock.unlock();
//                    Thread.sleep(SLEEP_SUB);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        long start_time = System.currentTimeMillis();
        //testObjectThread();
        //Thread.sleep(SLEEP_MAIN);
        //System.out.println("=========================================");

        //testVolatileThread();
        //Thread.sleep(SLEEP_MAIN);
        //System.out.println("=========================================");

        //testAtomicThread();
        //Thread.sleep(SLEEP_MAIN);
        //System.out.println("=========================================");

        testReentrantLockThread();

        long end_time = System.currentTimeMillis();
        System.out.println("cost time : " + (end_time - start_time));
    }

    static void testObjectThread() {
        for (int i = 0; i < MAX; i++) {
            new ObjectThread(i).start();
        }
    }

    static void testVolatileThread() {
        for (int i = 0; i < MAX; i++) {
            new VolatileThread(i).start();
        }
    }

    static void testAtomicThread() {
        for (int i = 0; i < MAX; i++) {
            new AtomicThread(i).start();
        }
    }

    static void testReentrantLockThread() {
        for (int i = 0; i < MAX; i++) {
            new ReentrantLockThread(i).start();
        }
    }
}
