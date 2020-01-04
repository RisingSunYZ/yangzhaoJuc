package com.yangzhao.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 不能保证原子性
 * @Author:YangZhao
 * @Since:2020/1/4 15:00
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class TestVolatile2 {

    public static void main(String[] args) {
        DataDemo2 DataDemo2 = new DataDemo2();


        for(int i=1;i<=50;i++){
            new Thread(()->{
                for (int j = 0; j <1000 ; j++) {
                    DataDemo2.setAAdd();
                    DataDemo2.setJUCAAdd();
                }
//                System.out.println(Thread.currentThread().getName()+"--->"+DataDemo2.a);
//                System.out.println(Thread.currentThread().getName()+"--->"+DataDemo2.AtomicInteger);
            },i+"").start();
        }



        while (Thread.activeCount()>2){
            Thread.yield();
        }


        System.out.println(DataDemo2.a);
        System.out.println(DataDemo2.AtomicInteger);


    }

}

class DataDemo2{
     int a = 0;
//    volatile int a = 0;
    AtomicInteger AtomicInteger = new AtomicInteger(0);

     void setAAdd(){
        a++;
    }

    void setJUCAAdd(){
        AtomicInteger.getAndIncrement();
    }


}

