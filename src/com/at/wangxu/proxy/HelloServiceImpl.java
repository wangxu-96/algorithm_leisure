package com.at.wangxu.proxy;

public class HelloServiceImpl implements HelloService {
    @Override
    public void say() {
        System.out.println("hello world");
    }
}
