package com.at.wangxu.Executors;

import java.util.concurrent.*;

public class ExecutorsTest {
    public static void main(String[] args) throws InterruptedException {
//        //ExecutorService executorService= Executors.newCachedThreadPool();
//        LinkedBlockingQueue queue = new LinkedBlockingQueue<>();
//        ThreadPoolExecutor executorService = new ThreadPoolExecutor(2, 4, 2, TimeUnit.SECONDS,queue);
//        /*for (int i = 0; i < 10; i++) {
//            int finalI=i;
//            executorService.execute(()->{
//                System.out.println(finalI);
//            });
//        }*/
//        executorService.prestartAllCoreThreads();
//        executorService.execute(() -> {
//                    try {
//                        Thread.sleep(1000l);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//        );
//
//        executorService.shutdown();
//        //executorService.shutdown();

        LinkedBlockingQueue queue = new LinkedBlockingQueue();



        Thread thread = new Thread(()->{
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

    }
}
