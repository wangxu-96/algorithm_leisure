package com.at.wangxu.leetcode;

import java.util.function.IntConsumer;

public class FizzBuzzII {

    int n;
    int i = 1;
    public FizzBuzzII(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (i <= n){
            synchronized (this){
                while (!(i % 3 == 0 && i % 5 != 0)) {
                    if (i > n)
                        break;
                    wait();
                }
                if (i > n){
                    //notifyAll();
                    break;
                }
                printFizz.run();
                i ++;
                notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (i <= n){
            synchronized (this){
                while (!(i % 3 != 0 && i % 5 == 0)) {
                    if (i > n)
                        break;
                    wait();
                }
                if (i > n){
                    //notifyAll();
                    break;
                }
                printBuzz.run();
                i ++;
                notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

        while (i <= n){
            synchronized (this){
                while (!(i % 3 == 0 && i % 5 == 0)) {
                    if (i > n)
                        break;
                    wait();
                }
                if (i > n){
                    //notifyAll();
                    break;
                }
                printFizzBuzz.run();
                i ++;
                notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (i <= n){
            synchronized (this){
                while (!(i % 3 != 0 && i % 5 != 0)) {
                    if (i > n)
                        break;
                    wait();
                }
                if (i > n){
                    //notifyAll();
                    break;
                }
                printNumber.accept(i);
                i ++;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        IntConsumer consumer = System.out::println;

        FizzBuzzII fizzBuzz = new FizzBuzzII(15);

        new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.number(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
