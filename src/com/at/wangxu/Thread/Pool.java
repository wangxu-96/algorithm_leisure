package com.at.wangxu.Thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Pool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(()-> {
            Thread.sleep(3000);
            System.out.println("-----------");
            return 1+2;
        });
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(futureTask);
        executorService.shutdown();

        Integer integer = futureTask.get();
        System.out.println(integer);
    }
}
