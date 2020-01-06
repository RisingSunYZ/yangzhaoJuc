package com.yangzhao.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description: 自旋锁
 * @Author:YangZhao
 * @Since:2020/1/6 15:08
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class SpinLockDemo {
    static AtomicReference<Thread> AtomicReference = new AtomicReference();

    public static void main(String[] args) {
        SpinLockDemo SpinLockDemo = new SpinLockDemo();
        new Thread(()->{
            SpinLockDemo.lock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
            SpinLockDemo.unlock();

        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }


        new Thread(()->{
            SpinLockDemo.lock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            SpinLockDemo.unlock();
        },"B").start();
    }


    private  void lock(){
        System.out.println(Thread.currentThread().getName()+"lock comein..........");

        while(!AtomicReference.compareAndSet(null,Thread.currentThread())){
            try {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName()+"lock自旋中..................");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private void unlock(){
        System.out.println(Thread.currentThread().getName()+"unlock comein..........");
        AtomicReference.compareAndSet(Thread.currentThread(),null);

    }


}
