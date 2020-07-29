package com.yangzhao.designPattern.mediator;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/29 17:03
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Coffe extends Colleague{

    public Coffe(String name, Mediator mediator) {
        super(name, mediator);
        this.mediator.registered(name,this);
    }

    public void drinkCoffee(){
        System.out.println("喝咖啡");
    }

    public void doCoffee(){
        System.out.println("煮咖啡");
    }

    public void finishCoffee(){
        System.out.println("五分钟后咖啡好了");
        this.sendMessage(0);
    }

    @Override
    protected void sendMessage(int index) {
        this.mediator.getMessage(index,name);
    }


}
