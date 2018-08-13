package com.at.wangxu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BookFacadeProxy implements InvocationHandler {
    @Override
    /**
     * 包装调用方法：进行预处理，调用后处理
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        System.out.println("预处理操作-------");
        //调用真正的业务方法
        result=method.invoke(target,args);
        System.out.println("调用后处理操作-------");
        return result;
    }

    private Object target;

    /**
     * 绑定一个业务对象并返回一个代理类
     * @param object
     * @return
     */
    public Object bind(Object object){
        this.target=object;//接收业务实现类对象参数
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);

    }
}
