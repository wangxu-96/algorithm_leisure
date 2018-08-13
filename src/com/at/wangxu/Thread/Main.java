package com.at.wangxu.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args){
        Main main1=new Main();
        Main main2=new Main();
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(()->main1.test(1));
        executorService.execute(()->main2.test(2));
        executorService.shutdown();
    }

    private void test(int i) {
        synchronized (this){
            for (int j = 0; j < 100; j++) {
                System.out.println(i);
            }
        }
    }
}
