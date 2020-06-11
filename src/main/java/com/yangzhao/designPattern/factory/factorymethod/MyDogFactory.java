package com.yangzhao.designPattern.factory.factorymethod;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/11 11:24
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class MyDogFactory implements Factory{
    @Override
    public Dog getAnimal(Class<? extends Animal> clazz) throws Exception {
        return (Dog)clazz.newInstance();
    }
}
