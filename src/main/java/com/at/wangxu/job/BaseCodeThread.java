package com.at.wangxu.job;

import java.awt.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 57237
 */
public class BaseCodeThread {

    private static Semaphore WORK_A = new Semaphore(1);
    private static Semaphore WORK_B = new Semaphore(0);
    private static Semaphore WORK_C = new Semaphore(0);
    private static  AtomicInteger count = new AtomicInteger(0);
    private static AtomicInteger num = new AtomicInteger(0);
    private static int allTimes = 300000;


    static class WorkThreadA extends Thread {
        @Override
        public void run() {
            try {
                while (num.getAndIncrement() < allTimes) {
                    WORK_A.acquire();
//                    System.out.println("work_threadA:"+ count.getAndIncrement());
                    WORK_B.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class WorkThreadB extends Thread {
        @Override
        public void run() {
            try {
                while (num.getAndIncrement() < allTimes) {
                    WORK_B.acquire();
//                    System.out.println("work_threadB:"+ count.getAndIncrement());
                    WORK_C.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class WorkThreadC extends Thread {
        @Override
        public void run() {
            try {
                while (num.getAndIncrement() < allTimes)  {
                    WORK_C.acquire();
//                    System.out.println("work_threadC:"+ count.getAndIncrement());
                    WORK_A.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        long start_time = System.currentTimeMillis();
        Thread A = new WorkThreadA();
        Thread B = new WorkThreadB();
        Thread C = new WorkThreadC();
        A.start();
        B.start();
        C.start();
        A.join();
        B.join();
        C.join();
        long end_time = System.currentTimeMillis();
        System.out.println("cost time:"+(end_time - start_time));
    }
}
