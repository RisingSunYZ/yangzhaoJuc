package com.yangzhao.myDemo.mybatis;

import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/27 13:25
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 *
 *
 *
 */
public class Test {


    public static void main(String[] args) {


        MapperProxy mapperProxy = new MapperProxy(TestMapper.class);

        TestMapper o = (TestMapper)Proxy.newProxyInstance(TestMapper.class.getClassLoader(), new Class[] { TestMapper.class }, mapperProxy);
        System.out.println(o.getClass().getName());
//        int zxczxc = o.insertLog("1", "zxczxc");
        Log log = o.selectLog("1");
        System.out.println(log);
    }
}
