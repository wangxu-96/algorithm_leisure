package com.at.wangxu.Thread;

public class VolatileDemo {
    private static  boolean flag = false;
    private static int i = 0;
    private static final int MAX_SIZE = 1000;

    public static void main(String[] args) {
        new Thread(() -> {
            while (i <= MAX_SIZE) {
                if (!flag) {
                    i++;
                    System.out.println(Thread.currentThread().getName() + "----" + i);
                    try {
                        Thread.sleep(100l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    flag = true;
                }

            }
        }, "Thread-1").start();

        new Thread(() -> {
            while (i <= MAX_SIZE) {
                if (flag) {
                    i++;
                    System.out.println(Thread.currentThread().getName() + "----" + i);
                    try {
                        Thread.sleep(100l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    flag = false;
                }

            }
        }, "Thread-2").start();
    }
}
