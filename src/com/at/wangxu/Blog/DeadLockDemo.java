package com.at.wangxu.Blog;

public class DeadLockDemo {
    private static String resource_a="A";
    private static String resource_b="B";
    public static void main(String[] args){
        deadLock();
    }

    private static void deadLock() {
        Thread thread1=new Thread(()->{
            synchronized (resource_a){
                System.out.println("get resource a---"+Thread.currentThread().getName() );
                try {
                    Thread.sleep(3000);
                    synchronized (resource_b){
                        System.out.println("get resource b"+Thread.currentThread().getName());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2=new Thread(()->{
            synchronized (resource_b){
                System.out.println("get resource b"+Thread.currentThread().getName());
                    synchronized(resource_a){
                        System.out.println("get resource a"+Thread.currentThread().getName());
                    }
            }
        });
        thread1.start();
        thread2.start();
    }
}
