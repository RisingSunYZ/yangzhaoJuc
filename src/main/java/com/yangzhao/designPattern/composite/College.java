package com.yangzhao.designPattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/29 15:36
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class College extends AbstractOrganization{

    private List<AbstractOrganization> systemes = new ArrayList<>();

    public College(String desc) {
        super(desc);
    }


    @Override
    void add(AbstractOrganization AbstractOrganization) {
        systemes.add(AbstractOrganization);
    }

    @Override
    void del(AbstractOrganization AbstractOrganization) {
        systemes.remove(AbstractOrganization);
    }

    @Override
    void print() {

        java.lang.System.out.println(getDesc());

        systemes.forEach(c->{
            c.print();
        });
    }
}
