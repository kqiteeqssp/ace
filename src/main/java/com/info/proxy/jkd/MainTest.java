package com.info.proxy.jkd;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * @Author: kqiteeq
 * @Description:
 * @Date:Created in 2019/1/20 21:31
 */
public class MainTest {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // 方式一:
        MyInvocationHandler handler = new MyInvocationHandler(new HelloPaoxyImpl());
        ClassLoader classLoader = MainTest.class.getClassLoader();
        Class[] interfaces = new Class[]{HelloProxy.class};
        HelloProxy proxy = (HelloProxy) Proxy.newProxyInstance(classLoader, interfaces, handler);
        proxy.sayHello("skr");
        //将生成的代理对象的字节码保存到本地
        createProxyClassFile();

        /*String path = MainTest.class.getResource("").getPath();
        System.out.println(path);*/
    }

    private static void createProxyClassFile() {

        // 代理生成的class文件名称
        String name = "ProxySubject";
        byte[] bytes = ProxyGenerator.generateProxyClass(name, new Class[]{HelloProxy.class});
        FileOutputStream out =  null;
        try {
            String path = MainTest.class.getResource("").getPath();
            String proxyFilePathName = path + name;
            out = new FileOutputStream(proxyFilePathName+".class");
            System.out.println("请到" + (new File(path)).getAbsolutePath() + "目录下查找生成的" + name + ".class代理文件");
            out.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=out){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}