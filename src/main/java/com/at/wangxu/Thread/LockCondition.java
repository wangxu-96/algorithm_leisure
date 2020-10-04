package com.at.wangxu.Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class LockCondition {

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    static volatile boolean done = false;

    public static void main(String[] args) throws InterruptedException {

        ReadWriteLock lock = new ReentrantReadWriteLock();
        lock.writeLock().newCondition();
        new Thread(()->{
            try {
                lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                signal();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }

    public static void lock() throws InterruptedException {
        lock.lock();
        try {
            while (!done) {
                System.out.println("wait");
                condition.await();
            }
            System.out.println("---- done");
        } finally {
            System.out.println("release lock");
            lock.unlock();
        }
    }
    public static void signal(){
        lock.lock();
        System.out.println("---lock");
        try {
            //done = true;
            condition.signalAll();
        }finally {
            lock.unlock();
            System.out.println("---un lock");
        }
    }


}
