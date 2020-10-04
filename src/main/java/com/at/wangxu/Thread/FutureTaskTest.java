package com.at.wangxu.Thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        FutureTask<String>  futureTask=new FutureTask<String>(()->{
            System.out.println("doing");
            Thread.sleep(1000);
            return "down";
        });
        executorService.submit(futureTask);
        System.out.println(futureTask.get());
        executorService.shutdown();
    }
}
