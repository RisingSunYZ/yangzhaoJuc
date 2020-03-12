package com.yangzhao.java8.proxy.staticproxy;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/11 13:34
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class AnimalManagerImpl  implements AnimalManager {
    @Override
    public String sayHellow(String vioce) {
        System.out.println("AnimalManagerImpl"+vioce);
        return "hello "+vioce;
    }
}
