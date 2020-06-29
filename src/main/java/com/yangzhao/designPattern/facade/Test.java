package com.yangzhao.designPattern.facade;

/**
 * @Description: 外观模式 //个人理解类似于service调用多个mapper
 *mybatis创建configuration 创建MetaObject
 * @Author:YangZhao
 * @Since:2020/6/29 17:45
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Test {

    public static void main(String[] args) {

        Facade Facade = new Facade();

        //看电影
        Facade.look();
        //不看了
        Facade.unlook();


    }
}
