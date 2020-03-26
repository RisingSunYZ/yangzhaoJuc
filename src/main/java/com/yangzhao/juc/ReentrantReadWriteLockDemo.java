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


/**
 * @Author YangZhao
 * @Description
 * @Date 11:43 2020/3/26
 * @Param
 * @return
 *
 * 1.Java并发库中ReetrantReadWriteLock实现了ReadWriteLock接口并添加了可重入的特性
 * 2.ReetrantReadWriteLock读写锁的效率明显高于synchronized关键字
 * 3.ReetrantReadWriteLock读写锁的实现中，读锁使用共享模式；写锁使用独占模式，换句话说，读锁可以在没有写锁的时候被多个线程同时持有，写锁是独占的
 * 4.ReetrantReadWriteLock读写锁的实现中，需要注意的，当有读锁时，写锁就不能获得；而当有写锁时，除了获得写锁的这个线程可以获得读锁外，其他线程不能获得读锁
 *


读写锁的实现必须确保写操作对读操作的内存影响。换句话说，一个获得了读锁的线程必须能看到前一个释放的写锁所更新的内容，读写锁之间为互斥。

ReentrantReadWriteLock支持锁降级，上面代码不会产生死锁。这段代码虽然不会导致死锁，但没有正确的释放锁。从写锁降级成读锁，并不会自动释放当前线程获取的写锁，仍然需要显示的释放，否则别的线程永远也获取不到写锁。

因为同一个线程中，在没有释放读锁的情况下，就去申请写锁，这属于锁升级，ReentrantReadWriteLock是不支持的。


获取锁顺序
非公平模式（默认）
当以非公平初始化时，读锁和写锁的获取的顺序是不确定的。非公平锁主张竞争获取，可能会延缓一个或多个读或写线程，但是会比公平锁有更高的吞吐量。
公平模式
当以公平模式初始化时，线程将会以队列的顺序获取锁。当当前线程释放锁后，等待时间最长的写锁线程就会被分配写锁；或者有一组读线程组等待时间比写线程长，那么这组读线程组将会被分配读锁。

 **/
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
