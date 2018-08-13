package com.at.wangxu.Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    private static final int COUNT=1000;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        CountDownLatch countDownLatch=new CountDownLatch(COUNT);
        for (int i = 0; i < COUNT; i++) {//countDown方法的执行次数一定要与countDownLatch的计数器数量一致，否则无法将计数器清空导致主线程无法继续执行
            int finalI=i;
            executorService.execute(()->{
                try {
                    Thread.sleep(3000);
                    System.out.println(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await(1, TimeUnit.SECONDS);//主线程只等1秒，超过之后继续执行主线程
        executorService.shutdown(); //当正在执行的线程执行完成之后再关闭而不是立即停止线程
        System.out.println("done");
    }
}
