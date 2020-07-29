package com.yangzhao.designPattern.mediator;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/29 17:45
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Test {


    public static void main(String[] args) {

        Mediator mediator = new ConcreteMediator();

        Tv tv = new Tv("Tv",mediator);
        Coffe Coffe = new Coffe("Coffee",mediator);
        Curtain Curtain = new Curtain("Curtain",mediator);
        Curtain.downCurtain();
        Coffe.finishCoffee();
        Curtain.upCurtain();

    }
}
