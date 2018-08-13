package com.at.wangxu.Thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {
    private static CyclicBarrier cyclicBarrier=new CyclicBarrier(10,()->{
        System.out.println("ready done callback");
    });
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            int finalI=i;
            Thread.sleep(1000);
            executorService.execute(()->{
                try {
                    System.out.println(finalI+" ready!");
                    cyclicBarrier.await();
                    //cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);//某个线程等待2s就报错
                    System.out.println(finalI+"go !");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
