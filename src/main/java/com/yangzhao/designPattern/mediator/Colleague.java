package com.yangzhao.designPattern.mediator;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/29 17:04
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public abstract class Colleague {

    protected String name;

    protected Mediator mediator;

    public Colleague(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    protected abstract void sendMessage(int index);
}
