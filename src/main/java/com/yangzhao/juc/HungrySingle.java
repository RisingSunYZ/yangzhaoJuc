package com.yangzhao.juc;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/1/4 15:55
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class HungrySingle {

    private static HungrySingle HungrySingle = new HungrySingle();

    private HungrySingle(){
        System.out.println("============comein===================");
    }

    public static HungrySingle getSingle(){
        return HungrySingle;
    }


}
