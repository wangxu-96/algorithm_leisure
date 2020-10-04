package com.at.wangxu.Thread;

public class WaitAndNotify {

    static int i = 1;
    static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (lock){
                while (i < 100) {
                    if (i == 100)
                        break;
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i);
            }
        }).start();


        new Thread(()->{
            synchronized (lock){
                while (i < 100){
                    i ++;
                    if (i == 100){
//                        lock.notifyAll();
                        break;
                    }
                }
            }
        }).start();


//        new Thread(() -> {
//            while (i <= 100) {
//                synchronized (lock) {
//                    if (i % 2 == 1) {
//                        //print odd
//                        System.out.println(i + Thread.currentThread().getName());
//                        i++;
//                        lock.notifyAll();
//                    } else {
//                        try {
//                            lock.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        }).start();
//
//        new Thread(() -> {
//            while (i <= 100) {
//                synchronized (lock) {
//                    if (i % 2 == 0) {
//                        //print even
//                        System.out.println(i + Thread.currentThread().getName());
//                        i++;
//                        lock.notifyAll();
//                    } else {
//                        try {
//                            lock.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//
//        }).start();
    }
}
