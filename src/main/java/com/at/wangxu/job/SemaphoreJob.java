package com.at.wangxu.job;

import java.util.concurrent.Semaphore;

public class SemaphoreJob {
    static final Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        task();
        task();
        task();
    }
    private static void task() {
        new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
        }).start();
    }
}
