package com.yangzhao.designPattern.adapter.interfaceadapter;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/16 18:15
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Test {

    public static void main(String[] args) {


        IAdapter iAdapter = new IAdapter() {
            @Override
            public void m1() {

            }

            @Override
            public void m2() {

            }
        };

        AbstractAdapter abstractAdapter = new AbstractAdapter() {
            @Override
            public void m2() {
                super.m2();
            }
        };


    }
}
