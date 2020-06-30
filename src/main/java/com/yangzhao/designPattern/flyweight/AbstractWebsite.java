package com.yangzhao.designPattern.flyweight;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/30 16:36
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public abstract class AbstractWebsite {


    //内部状态
    String type;

    public AbstractWebsite(String type) {
        this.type = type;
    }

    protected abstract void use(String use);

}
