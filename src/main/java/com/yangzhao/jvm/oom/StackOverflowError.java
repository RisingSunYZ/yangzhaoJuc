package com.yangzhao.jvm.oom;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/2/20 15:34
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class StackOverflowError {

    public static void main(String[] args) {

        test();
    }

    private static void test() {
        test();
    }
}
