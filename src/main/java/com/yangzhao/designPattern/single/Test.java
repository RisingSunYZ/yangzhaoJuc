package com.yangzhao.designPattern.single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/9 9:14
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Test {


    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        executorService.submit(()->{
//            饿汉两种
//            HungrySingle single = HungrySingle.getSingle();
//            HungrySingle2 single = HungrySingle2.getInstance();
//            LazySingle instance = LazySingle.getInstance();
//            InnerClassSingle instance = InnerClassSingle.getInstance();
            EnumSingle single = EnumSingle.getSingle();
            System.out.println(single.getStu());
        });


    }
}
