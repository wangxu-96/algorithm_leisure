package com.at.wangxu.Executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsTest {
    public static void main(String[] args){
        //ExecutorService executorService= Executors.newCachedThreadPool();
        ScheduledExecutorService executorService=Executors.newScheduledThreadPool(3);
        /*for (int i = 0; i < 10; i++) {
            int finalI=i;
            executorService.execute(()->{
                System.out.println(finalI);
            });
        }*/
        executorService.scheduleAtFixedRate(()->
            System.out.println("here"),1,2, TimeUnit.SECONDS
        );
        //executorService.shutdown();
    }
}
