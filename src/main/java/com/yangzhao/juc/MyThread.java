package com.yangzhao.juc;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/1/4 14:25
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("==================");
        System.out.printf(Thread.currentThread().getName());
    }
}
