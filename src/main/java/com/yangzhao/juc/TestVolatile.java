package com.yangzhao.juc;

/**
 * @Description: volatile 内存可见性
 * @Author:YangZhao
 * @Since:2020/1/4 14:36
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class TestVolatile {

    public static void main(String[] args) {
        MyDataDemo MyDataDemo = new MyDataDemo();


        new Thread(() -> {

            System.out.println("comein============================");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            MyDataDemo.setA();
            System.out.println(Thread.currentThread().getName() + "====>" + MyDataDemo.a);
        }, "yz").start();


        while (MyDataDemo.a == 10) {

        }

        System.out.println("back=====" + Thread.currentThread().getName() + "====>" + MyDataDemo.a);

    }

}

class MyDataDemo {
    volatile int a = 10;
//     int a = 10;


    void setA() {
        this.a = 60;
    }

}
