package com.yangzhao.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * /**
 *  * 初始值为0的变量，两个线程交替操作，一个+1，一个-1，执行五轮
 *  * 1 线程  操作  资源类
 *  * 2 判断  干活  通知
 *  * 3 防止虚假唤醒机制
 *
 * @Author:YangZhao
 * @Since:2020/1/7 13:57
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class ProviderCustomerTest {

    public static void main(String[] args) {

        ShareData ShareData = new ShareData();
        int temp = 5;

            new Thread(()->{
                for(int j=1;j<=temp;j++) {
                    ShareData.product();
                }
            },"AA").start();



            new Thread(()->{
                for(int j=1;j<=temp;j++) {
                    ShareData.customer();
                }
            },"BB").start();

        new Thread(()->{
            for(int j=1;j<=temp;j++) {
                ShareData.product();
            }
        },"CC").start();



        new Thread(()->{
            for(int j=1;j<=temp;j++) {
                ShareData.customer();
            }
        },"DD").start();





    }


}

class ShareData{

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    int i = 0;

    void product(){
        lock.lock();
        try {
            while(i ==5){
                condition.await();
            }
            i = i+1;
            System.out.println(Thread.currentThread().getName()+"生产了一个"+i);
            condition.signalAll();
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }


    void customer(){
        lock.lock();
        try {
            while(i ==0){
                condition.await();
            }
            i = i-1;
            System.out.println(Thread.currentThread().getName()+"消费了一个"+i);
            condition.signalAll();
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }



}
