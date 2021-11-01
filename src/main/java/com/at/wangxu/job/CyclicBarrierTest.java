package com.at.wangxu.job;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 黑眼镜
 * @description Test
 * @date 2021-08-18 17:38
 */
public class CyclicBarrierTest {

    static final int MAX = 100;
    private final List<CustomThread> list = new ArrayList<>();
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public CyclicBarrierTest(int threadNum) {
        CyclicBarrier barrier = new CyclicBarrier(threadNum, () -> {
            for (CustomThread task : list)
                if (task.getNum() >= MAX) {
                    executorService.shutdownNow();
                    return;
                } else {
                    task.printNum();
                }
        });
        for (int i = 0; i < threadNum; i++) {
            CustomThread thread = new CustomThread(barrier);
            list.add(thread);
            executorService.execute(thread);
        }
    }

    public static void main(String[] args) {
        new CyclicBarrierTest(3);
    }
}

class CustomThread implements Runnable {

    private static int count = 0;
    private final int id = count++;
    private static final AtomicInteger num = new AtomicInteger(0);

    private final CyclicBarrier cyclicBarrier;

    public CustomThread(CyclicBarrier b) {
        cyclicBarrier = b;
    }

    public int getNum() {
        return num.get();
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                cyclicBarrier.await();
            }
        } catch (BrokenBarrierException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void printNum() {
//        num.getAndIncrement();
        System.out.println(Thread.currentThread() + " Thread-" + (id) + ": " + (num.getAndIncrement()));
    }
}
