package com.at.wangxu.Thread;

import java.util.Random;

public class WrongResult {

    static final long MAX_VALUE = Long.MAX_VALUE;


    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();

        while (true) {
            long i = random.nextLong();
            String intern = String.valueOf(i);
            intern.intern();
            System.out.println(intern);
        }

    }
}
