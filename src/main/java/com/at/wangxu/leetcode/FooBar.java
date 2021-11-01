package com.at.wangxu.leetcode;

/**
 1115. 交替打印FooBar
 我们提供一个类：

 class FooBar {
 public void foo() {
 for (int i = 0; i < n; i++) {
 print("foo");
 }
 }

 public void bar() {
 for (int i = 0; i < n; i++) {
 print("bar");
 }
 }
 }
 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。

 请设计修改程序，以确保 "foobar" 被输出 n 次。



 示例 1:

 输入: n = 1
 输出: "foobar"
 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 示例 2:

 输入: n = 2
 输出: "foobarfoobar"
 解释: "foobar" 将被输出两次。
 *
 */
public class FooBar {
    private int n;
    private volatile boolean flag;
    private final Object lock;

    public FooBar(int n) {
        this.n = n;
        flag = true;
        lock = new Object();
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock){
                while (!flag)
                    lock.wait();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = false;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock){
                while (flag)
                    lock.wait();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = true;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(5);
        new Thread(()->{
            try {
                fooBar.bar(()-> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                fooBar.foo(()-> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }
}
