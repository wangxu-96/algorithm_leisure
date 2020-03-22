package com.at.coucurrent;

import java.util.concurrent.*;

/**
 * 线程池相关
 */
public class ExecutorPool {

    public static void main(String[] args) {

        ThreadPoolExecutor poolExecutor= new ThreadPoolExecutor(50, 60,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());

        //poolExecutor.prestartAllCoreThreads();

        poolExecutor.execute(()-> System.out.println(-1 << (Integer.SIZE-3)));
    }
}
