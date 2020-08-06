package com.at.coucurrent;

import java.util.concurrent.*;

/**
 * 线程池相关
 */
public class ExecutorPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor poolExecutor= new ThreadPoolExecutor(50, 60,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());

        //poolExecutor.prestartAllCoreThreads();

        Future<Integer> submit = poolExecutor.submit(() -> {
            Thread.sleep(3000l);
            return 1;
        });

        poolExecutor.shutdown();

        System.out.println(submit.get());
    }
}
