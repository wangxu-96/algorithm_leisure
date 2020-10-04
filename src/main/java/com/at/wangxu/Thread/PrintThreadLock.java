package com.at.wangxu.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintThreadLock {

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static int i = 0;


    public static void main(String[] args) {
        new Thread(()->{
            while (i <= 10){
                try {
                    lock.lock();
                    if (i % 2 ==0){
                        System.out.println(Thread.currentThread().getName()+i);
                        i++;
                        condition.signalAll();
                    }else {
                        condition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        },"Thread-1:").start();

        new Thread(()->{
            while (i <= 10){
                try {
                    lock.lock();
                    if (i % 2 ==1){
                        System.out.println(Thread.currentThread().getName()+i);
                        i++;
                        condition.signalAll();
                    }else {
                        condition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        },"Thread-2:").start();
    }

}
