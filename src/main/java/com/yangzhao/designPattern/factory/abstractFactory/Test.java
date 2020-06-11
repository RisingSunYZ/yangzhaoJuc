package com.yangzhao.designPattern.factory.abstractFactory;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/11 15:23
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Test {

    public static void main(String[] args) {

        Factory factory = new BaishiFactory();
        IDrinks cole = factory.getCole();
        IDrinks cole2 = factory.getMile();
        cole.say();
        cole2.say();

        Factory factory1 = new ColeFactory();

        IDrinks cole3 = factory1.getCole();
        IDrinks cole4 = factory1.getMile();
        cole3.say();
        cole4.say();



    }
}
