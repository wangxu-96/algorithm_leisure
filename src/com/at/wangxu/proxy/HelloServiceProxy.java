package com.at.wangxu.proxy;

public class HelloServiceProxy  {
    public void say() {
        System.out.println("记录日志");
        target.say();
        System.out.println("清理数据");
    }
    public HelloService target;

    public HelloServiceProxy(HelloService target) {
        this.target = target;
    }
}
