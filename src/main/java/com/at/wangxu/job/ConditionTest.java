package com.at.wangxu.job;

import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    private static final int MAX = 3;
    private static final int OVER = 300_000;
    private static final long SLEEP_SUB = 30;
    private static final long SLEEP_MAIN = 2000;

    private static int count = 0;
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    static class ObjectThread extends Thread {

        private final int index;
        private final CountDownLatch latch;

        public ObjectThread(int _index, CountDownLatch latch) {
            this.index = _index;
            this.latch = latch;
            super.setName("Thread-" + index);
        }

        @Override
        public void run() {
            try {
                lock.lock();
                while (count < OVER) {
                    while (count % MAX != index) {
                        if (count >= OVER) break;
                        condition.await();
                    }

                    if (count >= OVER) {
                        condition.signalAll();
                        break;
                    }
//                    System.out.println(JavaThreadTest.ObjectThread.class.getSimpleName() + "-" + Thread.currentThread().getName() + ", count=" + (count++));
                    count++;
                    condition.signalAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                latch.countDown();
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(MAX);
        long start = Instant.now().toEpochMilli();
        for (int i = 0; i < MAX; i++) {
            new ConditionTest.ObjectThread(i,latch).start();
        }
        latch.await();
        long finish = Instant.now().toEpochMilli();
        System.out.println("cost: " + (finish - start));
    }
}
