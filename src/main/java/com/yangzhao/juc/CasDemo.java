package com.yangzhao.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:CAS是指Compare And Swap，比较并交换，是一种很重要的同步思想。如果主内存的值跟期望值一样，那么就进行修改，否则一直重试，直到一致为止
 * @Author:YangZhao
 * @Since:2020/1/4 16:43
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class CasDemo {

    public static void main(String[] args) {

//        CAS实际上是一种自旋锁，
//
//        一直循环，开销比较大。
//        只能保证一个变量的原子操作，多个变量依然要加锁。
//        引出了ABA问题。
        // private static final Unsafe unsafe = Unsafe.getUnsafe();
        //  private volatile int value;
        AtomicInteger AtomicInteger = new AtomicInteger(10);
        boolean b = AtomicInteger.compareAndSet(10, 12);
        System.out.println(AtomicInteger.get());
        System.out.println(b);
        boolean b1 = AtomicInteger.compareAndSet(10, 16);
        System.out.println(AtomicInteger.get());
        System.out.println(b1);
    }


}
