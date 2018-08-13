package com.at.wangxu.proxy;

public class Main {
    public static void main(String[] args){
        HelloService target=new HelloServiceImpl();
        HelloServiceProxy proxy=new HelloServiceProxy(target);
        proxy.say();
    }
}
