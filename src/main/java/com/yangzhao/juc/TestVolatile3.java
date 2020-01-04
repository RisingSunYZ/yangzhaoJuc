package com.yangzhao.juc;

/**
 * @Description: 禁止指令重排
 * @Author:YangZhao
 * @Since:2020/1/4 15:39
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class TestVolatile3 {

    public static void main(String[] args) {

        Test test = new Test();
        for(int i=1;i<10000;i++){
            new Thread(()->{
                test.first();
            },i+"").start();
        }

    }


}


class Test{
//    volatile int a = 0;
//    volatile boolean flag = false;
     int a = 0;
     boolean flag = false;

    synchronized void first(){
        a= 1;
        flag = true;
        sencod();
    }

    void sencod(){
        if(flag){
            a +=5;
        }
        if(a == 5){
            System.out.println("===================================");
        }
        System.out.println(a);
    }



}
