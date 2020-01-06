package com.yangzhao.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description: 读写锁
 * @Author:YangZhao
 * @Since:2020/1/6 15:43
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class ReentrantReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache MyCache = new MyCache();



        for(int i=1;i<=5;i++){
            final int tempInt = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"开始写入................");
                try{
                    TimeUnit.SECONDS.sleep(3);
                }catch (Exception e){
                    e.printStackTrace();
                }
                MyCache.write(tempInt+"",tempInt+"");
                System.out.println(Thread.currentThread().getName()+"写入完成................"+"时间"+System.currentTimeMillis());
            },i+"").start();
        }




        for(int i=1;i<=5;i++){
            final int tempInt = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"开始读取................");
                try{
                    TimeUnit.SECONDS.sleep(3);
                }catch (Exception e){
                    e.printStackTrace();
                }
                String s = MyCache.read(tempInt+"");
                System.out.println(Thread.currentThread().getName()+"读取的值为"+s+"时间"+System.currentTimeMillis());
            },i+"").start();
        }


    }
}



class MyCache{

    ReentrantReadWriteLock ReentrantReadWriteLock = new ReentrantReadWriteLock();
    private Map<String,String> map = new HashMap<>();

    void write(String key,String val){
        ReentrantReadWriteLock.writeLock().lock();
        try{
            map.put(key,val);
        }finally {
            ReentrantReadWriteLock.writeLock().unlock();
        }
    }

    String read(String key){
        ReentrantReadWriteLock.readLock().lock();
        try{
           return map.get(key);
        }finally {
            ReentrantReadWriteLock.readLock().unlock();
        }
    }


}
