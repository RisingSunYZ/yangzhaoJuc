package com.yangzhao.designPattern.factory.abstractFactory;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/11 15:13
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public abstract class AbstractColeDrinks implements IDrinks{

    @Override
    public void say() {
        System.out.println("我是可乐");
        satMore();
    }

    abstract void satMore();
}
