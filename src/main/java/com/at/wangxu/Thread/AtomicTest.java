package com.at.wangxu.Thread;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicTest {

    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong(0);

        System.out.println(atomicLong.get());
        System.out.println(atomicLong.getAndIncrement());
        System.out.println(atomicLong.getAndIncrement());
        System.out.println(atomicLong.get());
    }
}
