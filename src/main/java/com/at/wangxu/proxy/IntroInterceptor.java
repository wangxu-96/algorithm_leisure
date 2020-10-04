package com.at.wangxu.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class IntroInterceptor implements IHello, MethodInterceptor {
    private Object delegate;

    public Object getDelegate() {
        return delegate;
    }

    public void setDelegate(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public void sayHello() {
        System.out.println("Say hello from delegate.");
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Class<?> declaringClass = method.getDeclaringClass();
        if (declaringClass.isAssignableFrom(IHello.class)){
            return method.invoke(delegate,objects);
        }
        return methodProxy.invokeSuper(o,objects);
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Service.class);
        enhancer.setInterfaces(new Class[]{IHello.class});
        enhancer.setCallback(new IntroInterceptor());

        Service o = (Service) enhancer.create();
        o.sayBye();

        IHello iHello = (IHello) o;
        iHello.sayHello();
    }
}
