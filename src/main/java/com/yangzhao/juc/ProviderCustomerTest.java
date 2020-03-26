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


/**
 * @Author YangZhao
 * @Description
 * @Date 14:09 2020/3/25
 * @Param
 *
 * @return
lockInterruptibly() 该方法尝试获取锁，若获取成功立即返回；若获取不成功则阻塞等待。与lock方法不同的是，在阻塞期间，如果当前线程被打断（interrupt）则该方法抛出InterruptedException。该方法提供了一种解除死锁的途径。
tryLock() 该方法试图获取锁，若该锁当前可用，则该方法立即获得锁并立即返回true；若锁当前不可用，则立即返回false。该方法不会阻塞，并提供给用户对于成功获利锁与获取锁失败进行不同操作的可能性。
tryLock(long time, TimeUnit unit) 该方法试图获得锁，若该锁当前可用，则立即获得锁并立即返回true。若锁当前不可用，则等待相应的时间（由该方法的两个参数决定）：1）若该时间内锁可用，则获得锁，并返回true；2）若等待期间当前线程被打断，则抛出InterruptedException；3）若等待时间结束仍未获得锁，则返回false。

 **/
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
