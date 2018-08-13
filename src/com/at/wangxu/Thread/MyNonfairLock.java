package com.at.wangxu.Thread;

import java.util.concurrent.locks.ReentrantLock;

public class MyNonfairLock {

    /**
     *     true 表示 ReentrantLock 的公平锁
     */
    private ReentrantLock lock = new ReentrantLock(false);

    public void testFail(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"获得了锁");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        MyNonfairLock MyNonfairLock=new MyNonfairLock();
        Runnable runnable=()->{
            System.out.println(Thread.currentThread().getName()+"启动");
            MyNonfairLock.testFail();
        };
        Thread[]   threadArray=new Thread[10];
        for (int i=0;i<10;i++){
            threadArray[i]=new Thread(runnable);
        }
        for (int i=0;i<10;i++){
            threadArray[i].start();
        }
    }
}
