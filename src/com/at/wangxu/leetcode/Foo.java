package com.at.wangxu.leetcode;

/**
 * 1114. 按序打印
 *
 * 我们提供了一个类：
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用 second() 方法
 * 线程 C 将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: "firstsecondthird"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
 * 正确的输出是 "firstsecondthird"。
 * 示例 2:
 *
 * 输入: [1,3,2]
 * 输出: "firstsecondthird"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。
 * 正确的输出是 "firstsecondthird"。
 *  
 *
 * 提示：
 *
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * 你看到的输入格式主要是为了确保测试的全面性。
 *
 *
 */
public class Foo {

    //使用wait notify
    final Object lock;
    volatile int a;

    public Foo() {
        lock = new Object();
        a = 1;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock){
            while (a != 1)
                lock.wait();

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            a = 2;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock){
            while (a != 2)
                lock.wait();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            a = 3;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock){
            while (a != 3)
                lock.wait();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            a = -1;
            lock.notifyAll();
        }
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third invoke"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first invoke"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second invoke"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
