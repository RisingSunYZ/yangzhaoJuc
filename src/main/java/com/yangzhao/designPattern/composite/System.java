package com.yangzhao.designPattern.composite;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/29 15:37
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class System extends  AbstractOrganization{
    public System(String desc) {
        super(desc);
    }


    @Override
    void add(AbstractOrganization AbstractOrganization) {
        throw new UnsupportedOperationException();
    }

    @Override
    void del(AbstractOrganization AbstractOrganization) {
        throw new UnsupportedOperationException();
    }

    @Override
    void print() {
        java.lang.System.out.println(getDesc());
    }
}
