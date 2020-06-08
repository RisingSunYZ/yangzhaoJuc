package com.yangzhao.other.spi;

import java.util.ServiceLoader;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/8 17:33
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class SpiTest {

    public static void main(String[] args) {

        ServiceLoader<MySpiInterface> load = ServiceLoader.load(MySpiInterface.class);
        for (MySpiInterface u : load) {
            u.sayHello();
        }

    }
}
