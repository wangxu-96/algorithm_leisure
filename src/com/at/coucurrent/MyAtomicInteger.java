package com.at.coucurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomicInteger {

    private volatile int value;

    private static long offset;

    private static Unsafe unsafe;

    static {
        try {
            Field theUnsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafeField.setAccessible(true);
            unsafe = (Unsafe) theUnsafeField.get(null);
            Field field = MyAtomicInteger.class.getDeclaredField("value");
            offset = unsafe.objectFieldOffset(field);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void increment(int num){
        int tempValue;
        do {
            tempValue = unsafe.getIntVolatile(this,offset);
        }while (!unsafe.compareAndSwapInt(this,offset,tempValue,value+num));
    }

    public int get(){
        return value;
    }

    boolean compareAndSet(int expect,int update){
       return unsafe.compareAndSwapInt(this, offset, expect, update);
    }

    public static void main(String[] args) {
        MyAtomicInteger atomicInteger = new MyAtomicInteger();
        atomicInteger.value = 0;
        int expect = 0;
        int update = 1;
        do {
            System.out.println("CAS retry");
        }while (!atomicInteger.compareAndSet(expect,update));
        System.out.println(atomicInteger.value);

        //synchronized
        long startTime = System.currentTimeMillis();
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        List<Future<?>> futureList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Future<?> future= threadPool.submit(()->{
                for (int j = 0; j < 100000; j++) {
                    atomicInteger.getAndAdd();
                }
            });
            futureList.add(future);
        }
        threadPool.shutdown();

        futureList.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        System.out.println(atomicInteger.count);
        System.out.println("synchronized cost time " + (System.currentTimeMillis() - startTime) + "ms");

        //CAS
        startTime = System.currentTimeMillis();
        ExecutorService threadPool1 = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            Future<?> future= threadPool1.submit(()->{
                for (int j = 0; j < 100000; j++) {
                    atomicInteger.integer.incrementAndGet();
                }
            });
            futureList.add(future);
        }
        threadPool1.shutdown();

        futureList.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        System.out.println(atomicInteger.integer);
        System.out.println("atomic cost time " + (System.currentTimeMillis() - startTime) + "ms");
    }

    AtomicInteger integer = new AtomicInteger(0);
    int count;
    private synchronized void getAndAdd(){
        count ++;
    }

}
