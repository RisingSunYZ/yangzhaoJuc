package com.yangzhao.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/26 9:38
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 *
 * ReentrantLock 未能读写分离实现，虽然ReentrantReadWriteLock能够读写分离了，但是对于其写锁想要获取的话，就必须没有任何其他读写锁存在才可以，这实现了悲观读取。而且如果读操作很多，写很少的情况下，线程有可能遭遇饥饿问题。
 *
 * 饥饿问题：ReentrantReadWriteLock实现了读写分离，想要获取读锁就必须确保当前没有其他任何读写锁了，但是一旦读操作比较多的时候，想要获取写锁就变得比较困难了，因为当前有可能会一直存在读锁。而无法获得写锁。
 *
 * 这时候怎么办呢？于是在jdk1.8的时候引入了一个新的锁StampedLock。
 *
 *
 * StampedLock控制锁有三种模式（写，读，乐观读）
 *
 * （1）写入（Writing）：writeLock是一个独占锁，也是一个悲观锁。
 *
 * （2）读取（Reading）：readLock这时候是一个悲观锁。
 *
 * （3）乐观读取（Optimistic Reading）：提供了tryOptimisticRead方法返回一个非0的stamp，只有当前同步状态没有被写模式所占有是才能获取到。乐观读取模式仅用于短时间读取操作时经常能够降低竞争和提高吞吐量。同时使用的时候一般需要读取并存储到另外一个副本，以用做对比使用。下面干脆使用代码来实现一下这几种锁的实现。
 */
public class StampedLockDemo {


    private static final StampedLock stampedLock = new StampedLock();

    private static List list = new ArrayList<>();

    public static void main(String[] args) throws Exception{

        ExecutorService executorService = Executors.newFixedThreadPool(10);


        for(int i=0;i<9;i++){
            executorService.execute(()->{
                while(true){
//                    read();
                    optimisticRead();
                }

            });
        }

        executorService.execute(()->{
            while(true){
                write();
            }

        });

    }


    static void read(){
        long l = -1;
        try {
            l = stampedLock.readLock();
            System.out.println(Thread.currentThread().getName()+"获取读锁..................");
            for(int i=0;i<list.size();i++){
                System.out.println(Thread.currentThread().getName()+ "读取"+list.get(i));
            }

            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            stampedLock.unlockRead(l);
            System.out.println(Thread.currentThread().getName()+"释放读锁..................");
        }

    }

    static void optimisticRead(){
        long l = -1;

        try{
            l = stampedLock.tryOptimisticRead();
            System.out.println(Thread.currentThread().getName()+"获取乐观读锁..................");
            if(!stampedLock.validate(l)){
                l = stampedLock.readLock();
                System.out.println(Thread.currentThread().getName()+"获取读锁..................");
                for(int i=0;i<list.size();i++){
                    System.out.println(Thread.currentThread().getName()+ "读取"+list.get(i));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            stampedLock.unlockRead(l);
            System.out.println(Thread.currentThread().getName()+"释放读锁..................");
        }


    }

    static void write(){
        long l = -1;
        try {

            l = stampedLock.writeLock();
            System.out.println(Thread.currentThread().getName()+"获取写锁..................");
            list.add(l);
            System.out.println(Thread.currentThread().getName()+"写入的数据是:"+l);
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            stampedLock.unlockWrite(l);
            System.out.println(Thread.currentThread().getName()+"释放写锁..................");
        }

    }

}
