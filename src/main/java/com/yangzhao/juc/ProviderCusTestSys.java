package com.yangzhao.juc;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/1/7 15:40
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class ProviderCusTestSys {

    public static void main(String[] args) throws Exception{
        SysShareData ShareData = new SysShareData();
        int temp = 5;

            new Thread(()->{
                for(int j=1;j<=temp;j++) {
                    try {
                        ShareData.provider();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"AA").start();



            new Thread(()->{
                for(int j=1;j<=temp;j++) {
                    try {
                        ShareData.cus();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"BB").start();

        new Thread(()->{
            for(int j=1;j<=temp;j++) {
                try {
                    ShareData.provider();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();



        new Thread(()->{
            for(int j=1;j<=temp;j++) {
                try {
                    ShareData.cus();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"DD").start();


    }
}

class SysShareData{

    int i = 0;

    synchronized void provider() throws InterruptedException {
        while(i == 5){
           this.wait();
        }
        i++;
        System.out.println(Thread.currentThread().getName()+"生产了"+i);
        this.notifyAll();
        TimeUnit.SECONDS.sleep(1);
    }

    synchronized void cus() throws InterruptedException {
        while(i == 0){
            this.wait();
        }
        i--;
        System.out.println(Thread.currentThread().getName()+"消费了"+i);
        this.notifyAll();
        TimeUnit.SECONDS.sleep(1);
    }


}
