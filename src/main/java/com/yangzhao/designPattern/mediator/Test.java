package com.yangzhao.designPattern.mediator;

/**
 * @Description:
 * @Author:YangZhao 中介者模式
 * 看了几个 demo  基本都是 调用成员类方法(sendMessage) 其实本职就是调用 中介者的方法(参数都会有自身的引用 this，
 * operate 里面有一些判断不同的类型有不同逻辑，然后在调用中介者的getMessage方法实现分发)
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
