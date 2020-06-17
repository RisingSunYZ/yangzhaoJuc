package com.yangzhao.designPattern.adapter.classadapter;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/16 18:09
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Clinet {

    public static void main(String[] args) {

        IDog dog = new dog();
        System.out.println(dog.say());



        IDog dog2 = new DogAdapter();
        System.out.println(dog2.say());

    }
}
