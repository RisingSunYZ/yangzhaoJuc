package com.yangzhao.designPattern.single;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/8 17:57
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class HungrySingle2 {

    private HungrySingle2(){
        System.out.println("HungrySingle2 init ............");
    };

    private static HungrySingle2 hungrySingle2 = null;

    static {
        hungrySingle2 = new HungrySingle2();
    }

    public static HungrySingle2 getInstance(){
        return hungrySingle2;
    }

}
