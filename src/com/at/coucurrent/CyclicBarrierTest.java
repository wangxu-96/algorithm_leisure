package com.at.coucurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args){
        final CyclicBarrier cyclicBarrier=new CyclicBarrier(2);
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                try {
                    System.out.println("before cyclic barrier");
                    cyclicBarrier.await();
                    System.out.println("after cyclic barrier");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
