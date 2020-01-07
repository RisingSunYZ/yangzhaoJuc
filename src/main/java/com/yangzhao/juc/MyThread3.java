package com.yangzhao.juc;

import java.util.concurrent.Callable;

/**
 * @Description:与Runnable的区别：
 * Callable带返回值。
 * 会抛出异常。
 * 覆写call()方法，而不是run()方法。
 * @Author:YangZhao
 * @Since:2020/1/7 13:50
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class MyThread3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("sout==================");
        return "helloWorld";
    }
}
