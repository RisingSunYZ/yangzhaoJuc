package com.yangzhao.juc;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/2/23 18:23
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class SysTest {

    public static void main(String[] args) throws Exception{


        SysData sysData = new SysData();

        for(int i=0;i<50;i++){
            new Thread(()->{
                for(int j=0;j<1000;j++){
                    synchronized (SysData.class){
//                    synchronized (sysData){
                        sysData.setI();
                    };

                }
            },String.valueOf(i)).start();
        }

        TimeUnit.SECONDS.sleep(10);
        System.out.println(sysData.i);

    }

}


class SysData{

    int i=0;

    void setI(){
        i++;
    }

//    synchronized void setI(){
//       i++;
//    }
}