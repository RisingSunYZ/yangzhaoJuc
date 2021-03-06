package com.yangzhao.designPattern.factory.factorymethod;

/**
 * @Description:
 * @Author:YangZhao  Calendar.getInstance();
 * @Since:2020/6/11 10:49
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class MyCatFactory implements Factory{

    @Override
    public Cat getAnimal(Class<? extends Animal> clazz) throws Exception {
        return (Cat)clazz.newInstance();
    }
}
