package com.at.coucurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

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

        do {

        }while (!atomicInteger.compareAndSet(0,1));
        System.out.println(atomicInteger.value);
    }

}
