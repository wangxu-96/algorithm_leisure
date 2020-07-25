package com.at.wangxu.Thread;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    private static final ReentrantLock lock=new ReentrantLock();
    public static void main(String[] args){
        for (int i = 0; i < 5; i++) {
            Thread thread=new Thread(()->{
                lock.lock();
                try {
//                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " get lock");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            });
            thread.start();
        }
    }
}
