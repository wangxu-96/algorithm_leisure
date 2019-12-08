package com.at.coucurrent;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * LeetCode 1115. Print FooBar Alternately
 * Suppose you are given the following code:
 *
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 *
 * The same instance of FooBar will be passed to two different threads.
 * Thread A will call foo() while thread B will call bar().
 * Modify the given program to output "foobar" n times.
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: "foobar"
 * Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar().
 * "foobar" is being output 1 time.
 * Example 2:
 *
 * Input: n = 2
 * Output: "foobarfoobar"
 * Explanation: "foobar" is being output 2 times.
 *
 */
public class PrintAlternately {

    private int n;

    private Semaphore semaphore1 = new Semaphore(0);
    private Semaphore semaphore2 = new Semaphore(1);

    final BlockingQueue<Boolean> queue1 = new ArrayBlockingQueue<>(1);
    final BlockingQueue<Boolean> queue2 = new ArrayBlockingQueue<>(1);
    public PrintAlternately(int n) {
        this.n = n;
    }

    /*public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore2.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphore1.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore1.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphore2.release();
        }
    }*/

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            queue1.offer(Boolean.TRUE);
            queue2.take();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            queue1.take();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            queue2.offer(Boolean.TRUE);

        }
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("please input times: ");
        String n = new Scanner(System.in).next();
        PrintAlternately printAlternately = new PrintAlternately(Integer.parseInt(n));

        new Thread(()->{
            try {
                printAlternately.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                printAlternately.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }
}
