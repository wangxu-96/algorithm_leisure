package com.at.wangxu.job;

import com.google.common.util.concurrent.RateLimiter;

public class CPSHandler {
    public static void main(String[] args) throws InterruptedException {
        final int MAX_CPS = 2;
        final RateLimiter rateLimiter = RateLimiter.create(MAX_CPS);
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                System.out.println(rateLimiter.tryAcquire());
                System.out.println(Thread.currentThread().getName() + "\t" + System.currentTimeMillis());
            }).start();
        }
    }
}
