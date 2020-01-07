package com.yangzhao.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/1/7 16:06
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class ConditionTest {

    public static void main(String[] args) {
        conditionTest();
    }


    static void conditionTest(){
        MyConditionData MyConditionData = new MyConditionData();
        new Thread(()->{
            for(int i=0;i<5;i++){
                try {
                    MyConditionData.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ;
            }
        },"A").start();

        new Thread(()->{
            for(int i=0;i<5;i++){
                try {
                    MyConditionData.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ;
            }
        },"B").start();

        new Thread(()->{
            for(int i=0;i<5;i++){
                try {
                    MyConditionData.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ;
            }
        },"C").start();

    }
}

class MyConditionData{

    int num = 1;
    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    void printA() throws InterruptedException {
        lock.lock();

        try{
            while(num != 1){
                conditionA.await();
            }

            System.out.println(Thread.currentThread().getName()+"========"+"AAAAAAAAAAAAAAAAAAAAAAAAA");
            num =2;
            conditionB.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    void printB() throws InterruptedException {

        lock.lock();

        try{
            while(num !=2){
                conditionB.await();
            }
            System.out.println(Thread.currentThread().getName()+"========"+"BBBBBBBBBBBBBBBB");
            num = 3;
            conditionC.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }

    void printC() throws InterruptedException {

        lock.lock();

        try{
            while(num !=3){
                conditionC.await();
            }
            System.out.println(Thread.currentThread().getName()+"========"+"CCCCCCCCCCCCCCCCCCCCC");
            num = 1;
            conditionA.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }


}
