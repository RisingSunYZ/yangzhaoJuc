package com.yangzhao.designPattern.proxy.dymicProxyjdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/11 10:43
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class JdkProxyHandler implements InvocationHandler {

    private Object targeObject;

    public JdkProxyHandler(Object targeObject) {
        this.targeObject = targeObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(!Objects.isNull(args)){
            for(int i=0;i<args.length;i++){
                System.out.println(args[i]);
            }
        }

        //默認 包名+$Proxy +数字 如 com.sun.proxy.$Proxy1
        System.out.println(proxy.getClass().getName());

        System.out.println("begin==============");
        Object invoke = method.invoke(targeObject, args);
        System.out.println("end==============");
        return invoke;
    }
}
