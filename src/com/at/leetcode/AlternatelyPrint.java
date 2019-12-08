package com.at.leetcode;

public class AlternatelyPrint {
    private static final Object lock = new Object();
    private static int i = 0;

    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                synchronized (lock){
                    if (i % 2 == 0 && i <=10){
                        System.out.println(i);
                        i++;
                        lock.notify();
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
            while (true){
                synchronized (lock){
                    if (i % 2 == 1 && i <=10){
                        System.out.println(i);
                        i++;
                        lock.notify();
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
