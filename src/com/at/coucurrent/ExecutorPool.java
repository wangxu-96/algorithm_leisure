package com.at.coucurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池相关
 */
public class ExecutorPool {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(50);

        executorService.execute(()-> {
            System.out.println("------------");
        });
    }
}
