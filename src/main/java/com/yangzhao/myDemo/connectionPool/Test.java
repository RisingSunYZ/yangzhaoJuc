package com.yangzhao.myDemo.connectionPool;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/26 14:09
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Test {

    public static void main(String[] args) throws Exception{
        ExtConnectionPool ExtConnectionPool = new ExtConnectionPool();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i=0;i<3;i++){
            executorService.submit(()->{
                try{
                   while(true){
                       Connection con = ExtConnectionPool.getCon();
                       System.out.println(Thread.currentThread().getName()+"获取连接"+ con);
                       TimeUnit.SECONDS.sleep(10);
                       ExtConnectionPool.release(con);
                       System.out.println(Thread.currentThread().getName()+"释放连接"+ con);
                   }
                }catch (Exception e){
                    e.printStackTrace();
                }

            });
        }



    }
}
