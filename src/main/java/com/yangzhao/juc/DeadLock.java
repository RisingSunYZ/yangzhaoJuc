package com.yangzhao.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/1/15 20:01
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class DeadLock {


    public static void main(String[] args) throws Exception{


        Lock lock = new ReentrantLock();
        Lock lockB = new ReentrantLock();


        DeadLockData DeadLockData = new DeadLockData();

            new Thread(()->{
                try {
                    DeadLockData.setFlag(true,lock);
                    TimeUnit.SECONDS.sleep(2);
                    DeadLockData.setFlag2(true,lockB);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"AAAAA").start();


            new Thread(()->{
                try {
                    DeadLockData.setFlag(false,lockB);
                    DeadLockData.setFlag2(false,lock);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"BBBB").start();







    }
}

class DeadLockData{



    boolean flag;
    boolean flag2;


    public void setFlag(boolean flag,Lock lock) throws Exception{
        lock.lock();
        try{
            this.flag = flag;

        }finally {
            lock.unlock();
            System.out.println("setFlag====="+flag);
        }
    }

    public void setFlag2(boolean flag2,Lock lockB) throws Exception{
        lockB.lock();
        try{
            this.flag2 = flag2;

        }finally {
            lockB.unlock();
            System.out.println("setFlag2====="+flag2);
        }
    }


}




