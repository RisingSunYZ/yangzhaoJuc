package com.yangzhao.java8.proxy.dymicProxyjdk;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/11 16:42
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class CglibProxy implements MethodInterceptor {

    private Object tagget;

    public CglibProxy(Object o) {
        this.tagget = o;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("intercept...........begin");

        for(Object o1:objects){
            System.out.println(o1);
        }
        System.out.println(o.getClass().getName());
        System.out.println(tagget.getClass().getName());
        System.out.println(methodProxy.getClass());
        Object invoke = method.invoke(tagget, objects);

        System.out.println("intercept...........end");

        return invoke;
    }
}
