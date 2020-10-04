package com.at.leetcode;

public class AlternatelyPrint {
    private static final Object lock = new Object();
    private static int i = 0;

    public static void main(String[] args) {
        new Thread(()->{
            while (i <=10){
                synchronized (lock){
                    if (i % 2 == 0){
                        System.out.println(i);
                        i++;
                        lock.notify();
                    }else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        new Thread(()->{
            while (i <=10){
                synchronized (lock){
                    if (i % 2 == 1){
                        System.out.println(i);
                        i++;
                        lock.notify();

                    }else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}
