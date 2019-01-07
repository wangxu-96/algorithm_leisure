package com.at.coucurrent;


public class PrintNum {
    private  static Object lock=new Object();
    private static int i=0;
    public static void main(String[] args){
        new Thread(() ->{
            while (i<100){
                synchronized (lock){
                    if (i%2==0){
                        System.out.println(i+Thread.currentThread().getName());
                        i++;
                    }
                    lock.notify();
                    try {
                        lock.wait(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(() ->{
            while (i<100) {
                synchronized (lock){
                    if (i%2!=0){
                        System.out.println(i+Thread.currentThread().getName());
                        i++;
                    }
                    lock.notify();
                    try {
                        lock.wait(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();
    }
}
