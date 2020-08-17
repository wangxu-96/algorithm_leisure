package com.at.wangxu.Thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyTest {
    private static final int THREAD_COUNT=5000;
    private static final int CONCURRENT_COUNT=200;
    private static int count=0;
    private static Lock lock=new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("", "");
        ExecutorService executorService= Executors.newCachedThreadPool();
        Semaphore semaphore=new Semaphore(CONCURRENT_COUNT);
        CountDownLatch countDownLatch=new CountDownLatch(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(count);
    }

    private static void add() {
        lock.lock();
        try {
            count++;
        }finally {
            lock.unlock();
        }
    }
}
