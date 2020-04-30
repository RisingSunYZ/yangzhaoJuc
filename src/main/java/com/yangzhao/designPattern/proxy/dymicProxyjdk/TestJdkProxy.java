package com.yangzhao.designPattern.proxy.dymicProxyjdk;

import com.yangzhao.designPattern.proxy.staticproxy.*;

import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/11 10:54
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class TestJdkProxy {

    public static void main(String[] args) {
        UserManagerImpl userManager = new UserManagerImpl();
        JdkProxyHandler jdkProxyHandler = new JdkProxyHandler(userManager);

        UserManager o = (UserManager)Proxy.newProxyInstance(userManager.getClass().getClassLoader(), userManager.getClass().getInterfaces(), jdkProxyHandler);
        o.add();
        o.delete();

        UserManagerImpl1 userManager1 = new UserManagerImpl1();
        JdkProxyHandler jdkProxyHandler1 = new JdkProxyHandler(userManager1);

        UserManager o1 = (UserManager)Proxy.newProxyInstance(userManager1.getClass().getClassLoader(), userManager1.getClass().getInterfaces(), jdkProxyHandler1);
        o1.add();
        o1.delete();

        AnimalManagerImpl animalManagerImpl = new AnimalManagerImpl();
        JdkProxyHandler jdkProxyHandler2 = new JdkProxyHandler(animalManagerImpl);
        AnimalManager o2 = (AnimalManager)Proxy.newProxyInstance(animalManagerImpl.getClass().getClassLoader(), animalManagerImpl.getClass().getInterfaces(), jdkProxyHandler2);
        String lalalala = o2.sayHellow("lalalala");
        System.out.println(lalalala);
    }
}
