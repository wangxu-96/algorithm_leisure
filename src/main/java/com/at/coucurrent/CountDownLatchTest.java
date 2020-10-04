package com.at.coucurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    private static CountDownLatch count=new CountDownLatch(3);
    public static void main(String[] args) throws Exception{
        new Thread(()->{
            try {
                count.await();
                System.out.println("count final thread start");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        for (int i = 0; i <3 ; i++) {
            new Thread(()->{
                count.countDown();
                System.out.println("work thread start");
            }).start();
        }

    }
}
