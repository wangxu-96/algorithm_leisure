package com.at.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class DirectMemoryOOM {

    private static final int _1GB = 1024 * 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeFile = Unsafe.class.getDeclaredFields()[0];
        unsafeFile.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeFile.get(null);
        while (true){
            unsafe.allocateMemory(_1GB);
        }
    }
}
