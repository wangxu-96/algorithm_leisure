package com.at.wangxu.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    public static void main(String[] args){
        Lock lock=new ReentrantLock();
        Condition condition=lock.newCondition();
        Thread thread1=new Thread(()->{
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+"run");
                System.out.println(Thread.currentThread().getName()+"wait for condition");
                try{
                    condition.await();//将线程1放到Condition队列中等待被唤醒，且立即释放锁
                    System.out.println(Thread.currentThread().getName()+"continue");//线程2执行完毕释放锁，此时线程1已经在AQS等待队列中，则立即执行
                }catch (InterruptedException e){
                    System.err.println(Thread.currentThread().getName()+"interrupted");
                    Thread.currentThread().interrupted();
                }
            }finally {
                lock.unlock();
            }
        });
        Thread thread2=new Thread(()->{
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+"run");
                System.out.println(Thread.currentThread().getName()+"sleep 1 secs");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println(Thread.currentThread().getName()+"interrupted");
                    Thread.currentThread().interrupted();
                }
                condition.signalAll();//线程2获得锁，signalAll将Condition中的等待队列全部提取加入到AQS中
            }finally {
                lock.unlock();
            }
        });
        thread1.start();
        thread2.start();
    }
}
