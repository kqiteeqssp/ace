package com.info.proxy.jkd;

/**
 * @Author: kqiteeq
 * @Description:
 * @Date:Created in 2019/1/20 21:19
 */
public class HelloPaoxyImpl implements HelloProxy{


    @Override
    public void sayHello(String name) {
        System.out.println("Hello" + name);

    }
}