package com.yangzhao.designPattern.mediator;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/29 17:03
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public abstract class Mediator {


    public abstract void registered(String name,Colleague colleague);

    protected abstract void getMessage(int index,String name);

}
