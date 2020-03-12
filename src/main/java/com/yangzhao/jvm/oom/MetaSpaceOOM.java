package com.yangzhao.jvm.oom;

import com.yangzhao.java8.proxy.dymicProxyjdk.CglibProxy;
import com.yangzhao.java8.proxy.dymicProxyjdk.JdkProxyHandler;
import com.yangzhao.java8.proxy.staticproxy.UserManager;
import com.yangzhao.java8.proxy.staticproxy.UserManagerImpl;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/12 9:39  -XX:MaxMetaspaceSize=128m
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class MetaSpaceOOM {

    public static void main(String[] args) {
        testJdk();
        testCglib();

    }

    private static void testCglib() {

       while(true){
           UserManagerImpl UserManagerImpl = new UserManagerImpl();
           CglibProxy CglibProxy = new CglibProxy(UserManagerImpl);

           Enhancer Enhancer = new Enhancer();
           Enhancer.setSuperclass(UserManagerImpl.class);
           Enhancer.setCallback(CglibProxy);
           UserManagerImpl o = (UserManagerImpl)Enhancer.create();
           UserManagerImpl.add();
       }
    }

    private static void testJdk() {
        int i=0;
        while(true){
            try{
                i++;
                UserManagerImpl UserManagerImpl = new UserManagerImpl();
                JdkProxyHandler JdkProxyHandler = new JdkProxyHandler(UserManagerImpl);

                UserManager o = (UserManager)Proxy.newProxyInstance(UserManagerImpl.getClass().getClassLoader(), UserManagerImpl.getClass().getInterfaces(), JdkProxyHandler);
                o.add();
            }catch (Exception e){
                System.out.println("第"+i+"次出现异常");
                e.printStackTrace();
            }
        }
    }
}
