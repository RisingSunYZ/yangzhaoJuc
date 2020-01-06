package com.yangzhao.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 可重入锁
 * @Author:YangZhao
 * @Since:2020/1/6 14:24
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class ChongRuLock {
    public static void main(String[] args) {
//        new Thread(()->{
//            testSynchronized();
//        },"A").start();
//        new Thread(()->{
//            testSynchronized();
//        },"B").start();


        MyData MyData = new MyData();

        Thread thread = new Thread(MyData);
        Thread thread1 = new Thread(MyData);
        thread.start();
        thread1.start();

    }


    private static synchronized void testSynchronized(){
        System.out.println(Thread.currentThread().getName()+"come in testSynchronized.....");
        testSynchronizedB();
    }


    private static synchronized void testSynchronizedB(){
        System.out.println(Thread.currentThread().getName()+"come in testSynchronizedB.....");
    }

}

class MyData implements Runnable{

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        testLock();
    }


    private void testLock(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"come in testLock.....");
            testLockB();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }


    private void testLockB(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"come in testLockB.....");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

}
