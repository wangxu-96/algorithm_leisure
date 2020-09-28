package com.at.wangxu.Thread;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.park();

            System.out.println("-");
        });

        thread.start();
        LockSupport.unpark(thread);


    }
}
