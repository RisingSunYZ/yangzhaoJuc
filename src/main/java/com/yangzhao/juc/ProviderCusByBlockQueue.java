package com.yangzhao.juc;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/1/13 17:27
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class ProviderCusByBlockQueue {

    public static void main(String[] args) throws Exception{
        MyBlockQueueData MyBlockQueueData = new MyBlockQueueData(new ArrayBlockingQueue<>(2));
        new Thread(()->{
            try {
                MyBlockQueueData.prodiver();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"AA").start();

        new Thread(()->{
            try {
                MyBlockQueueData.prodiver();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"CC").start();


        new Thread(()->{
            try {
                MyBlockQueueData.cus();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"BB").start();

        new Thread(()->{
            try {
                MyBlockQueueData.cus();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"DD").start();


        new Thread(()->{
            try {
                MyBlockQueueData.prodiver();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"EE").start();


        new Thread(()->{
            try {
                MyBlockQueueData.cus();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"FF").start();

        TimeUnit.SECONDS.sleep(5);

        MyBlockQueueData.setStart();


    }
}


class MyBlockQueueData{

    private volatile boolean start = true;

    private BlockingQueue<Integer> blockingQueue;

    private AtomicInteger atomicInteger = new AtomicInteger(1);

    public MyBlockQueueData(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void setStart() {
        this.start = false;
    }

    void prodiver() throws Exception{
        System.out.println(Thread.currentThread().getName()+"开始生产......");
        while(start){
            int andIncrement = atomicInteger.getAndIncrement();
            boolean offer = blockingQueue.offer(andIncrement, 2, TimeUnit.SECONDS);
            if(offer){
                System.out.println(Thread.currentThread().getName()+"生产了"+andIncrement);
            }else{
                System.out.println(Thread.currentThread().getName()+"生产失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println(Thread.currentThread().getName()+"结束生产......");
    }


    void cus() throws Exception{

        System.out.println(Thread.currentThread().getName()+"开始消费......");
        while(start){
            Integer  a = blockingQueue.poll(2, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName()+"消费了"+a);

            if(Objects.isNull(a) || "".equals(a)){
                setStart();
                break;
            }

        }

        System.out.println(Thread.currentThread().getName()+"结束消费......");
    }

}
