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

    /**
     【强制】在高并发场景中，避免使用”等于”判断作为中断或退出的条件。
     说明：如果并发控制没有处理好，容易产生等值判断被“击穿”的情况，使用大于或小于的区间判断条件
     来代替。
     反例：判断剩余奖品数量等于 0 时，终止发放奖品，但因为并发处理错误导致奖品数量瞬间变成了负数，
     这样的话，活动无法终止。

     **/
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
