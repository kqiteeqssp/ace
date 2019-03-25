package com.info.proxy.jkd;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: kqiteeq
 * @Description:
 * @Date:Created in 2019/1/20 21:25
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invocation");
        Object real = method.invoke(target, args);
        System.out.println("After invocation");
        return real;
    }
}