package com.at.wangxu.Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    private static final ReentrantLock lock=new ReentrantLock();
    public static void main(String[] args){

        Thread thread = new Thread(()->{
            try {
                lock.lock();
                Thread.sleep(3000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("thread 0 exit");
        });

        Thread thread2 = new Thread(()->{
            try {
                lock.lock();
            }  finally {
                lock.unlock();
            }
            System.out.println("thread 2 exit");
        });

        Thread thread1 = new Thread(()->{
            try {
                lock.tryLock(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("thread 1 exit");
        });

        thread.start();
        thread2.start();
        thread1.start();

        thread1.interrupt();
    }
}
