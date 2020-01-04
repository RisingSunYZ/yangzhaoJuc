package com.yangzhao.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/1/4 17:06
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class ABAProblem {

    public static void main(String[] args) {
//        abaProblem();
        dealAbaProblem();
    }

    private static void dealAbaProblem(){
        AtomicStampedReference<Integer> AtomicStampedReference = new AtomicStampedReference(10,1);
        new Thread(()->{
            int stamp = AtomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"第一次当前版本号"+stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b = AtomicStampedReference.compareAndSet(10,12, stamp,AtomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+b+"=="+AtomicStampedReference.getReference());
            System.out.println(Thread.currentThread().getName()+"第二次当前版本号"+AtomicStampedReference.getStamp());
            boolean b1 = AtomicStampedReference.compareAndSet(12, 10, AtomicStampedReference.getStamp(), AtomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"第三次当前版本号"+AtomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName()+b1+"=="+AtomicStampedReference.getReference());
        },"t1").start();

        new Thread(()->{
            int stamp = AtomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"第一次当前版本号"+stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b2 = AtomicStampedReference.compareAndSet(10, 2019,stamp, AtomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+b2+"=="+AtomicStampedReference.getReference());
        },"t2").start();




    }


    private static void abaProblem(){
        System.out.println("======ABA问题的产生======");
        AtomicInteger AtomicInteger = new AtomicInteger(10);
        new Thread(()->{
            boolean b = AtomicInteger.compareAndSet(10, 12);
            System.out.println(Thread.currentThread().getName()+b+"=="+AtomicInteger.get());
            boolean b1 = AtomicInteger.compareAndSet(12, 10);
            System.out.println(Thread.currentThread().getName()+b1+"=="+AtomicInteger.get());
        },"t1").start();


        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean b2 = AtomicInteger.compareAndSet(10, 2019);
            System.out.println(Thread.currentThread().getName()+b2+"=="+AtomicInteger.get());
        },"t2").start();

    }

}
