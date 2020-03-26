package com.yangzhao.juc;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/1/7 9:36
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 *
 * 从使用场景上来说，CyclicBarrier是让多个线程互相等待某一事件的发生，然后同时被唤醒。而上文讲的CountDownLatch是让某一线程等待多个线程的状态，然后该线程被唤醒。
 */
public class CountDownDemo {

    public static void main(String[] args) throws Exception{
//        testCountDown();
        testCyclicBarrier();
//        testSemaphore();
    }


    static void testCountDown() throws Exception{
        CountDownLatch CountDownLatch = new CountDownLatch(6);

        for(int i=0;i<6;i++){
            final int temp = i;
            new Thread(()->{
                System.out.println(temp+"被收购");
                CountDownLatch.countDown();
            },i+"").start();
        }

        CountDownLatch.await();

        System.out.println("i am over");


    }

    static void testCyclicBarrier() throws Exception{
        CyclicBarrier CyclicBarrier = new CyclicBarrier(3,()->{
            System.out.println("main over");
        });

        for(int i=0;i<3;i++){
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"begin ");
                    CyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+"run over");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },i+"").start();
        }
    }

    static void testSemaphore(){
        Semaphore Semaphore = new Semaphore(3);

        for(int i=0;i<6;i++){
            new Thread(()->{
                try {
                    Semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"come in"+System.currentTimeMillis());
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Semaphore.release();
                    System.out.println(Thread.currentThread().getName()+"come out"+System.currentTimeMillis());
                }
            },i+"").start();
        }


    }


}
