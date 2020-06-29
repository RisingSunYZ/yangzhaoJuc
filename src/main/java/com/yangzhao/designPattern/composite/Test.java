package com.yangzhao.designPattern.composite;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/29 15:43
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Test {

    public static void main(String[] args) {

        AbstractOrganization system1 = new System("计算机科学与技术");
        AbstractOrganization system2 = new System("网络工程");
        AbstractOrganization system3 = new System("金融工程");
        AbstractOrganization system4 = new System("会计");

        AbstractOrganization college1 = new College("信息工程学院");
        AbstractOrganization college2 = new College("财经学院");
        AbstractOrganization university = new University("XXX牛逼大学");

        college1.add(system1);
        college1.add(system2);
        college2.add(system3);
        college2.add(system4);

        university.add(college1);
        university.add(college2);

//        university.print();
        college2.del(system3);
        college2.print();

    }
}
