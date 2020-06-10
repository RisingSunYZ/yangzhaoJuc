package com.yangzhao.designPattern.factory.factorymethod;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/10 16:41
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class AnimalFactory {

    public static <T>T  getAnimal(Class<? extends T> clazz) throws IllegalAccessException, InstantiationException {
        T animal = clazz.newInstance();
        return animal;
    }

//    public   E  getAnimal(Class<? extends E> clazz) throws IllegalAccessException, InstantiationException {
//        E animal = clazz.newInstance();
//        return animal;
//    }

}
