package com.yangzhao.jvm.oom;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/2/21 11:11
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 *
 * 在高并发应用场景时，如果创建超过了系统默认的最大线程数，就会抛出该异常。Linux单个进程默认不能超过1024个线程。解决方法要么降低程序线程数，要么修改系统最大线程数vim /etc/security/limits.d/90-nproc.conf
 */
public class UnableCreateNewThreadDemo {

    public static void main(String[] args) throws Exception{
        while(true){
            new Thread(()->{
                try{
                    TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }).start();
        }



    }
}
