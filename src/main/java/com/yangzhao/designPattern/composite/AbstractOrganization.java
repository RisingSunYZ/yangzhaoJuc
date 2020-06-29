package com.yangzhao.designPattern.composite;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/29 15:35
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public abstract class AbstractOrganization {

    protected  String desc;
    abstract void add(AbstractOrganization AbstractOrganization);
    abstract void del(AbstractOrganization AbstractOrganization);
    abstract void print();

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public AbstractOrganization(String desc) {
        this.desc = desc;
    }
}
