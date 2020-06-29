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
public class University extends AbstractOrganization{

    private List<AbstractOrganization> colleges = new ArrayList<>();

    public University(String desc) {
        super(desc);
    }


    @Override
    void add(AbstractOrganization AbstractOrganization) {
        colleges.add(AbstractOrganization);
    }

    @Override
    void del(AbstractOrganization AbstractOrganization) {
        colleges.remove(AbstractOrganization);
    }

    @Override
    void print() {

        java.lang.System.out.println(getDesc());

        colleges.forEach(c->{
            c.print();
        });

    }
}
