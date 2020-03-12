package com.yangzhao.java8.proxy.staticproxy;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/11 10:40
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        UserManager userManager = new LogUserManagerImpl(new UserManagerImpl());

        userManager.add();
        System.out.println("================");
        userManager.delete();
    }
}
