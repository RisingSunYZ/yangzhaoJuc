package com.yangzhao.designPattern.mediator;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/29 17:04
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Curtain extends Colleague{

    public Curtain(String name, Mediator mediator) {
        super(name, mediator);
        this.mediator.registered(name,this);
    }


    public void downCurtain(){
        System.out.println("放下窗帘");
        this.sendMessage(0);
    }

    public void upCurtain(){
        System.out.println("拉起窗帘");
        this.sendMessage(1);
    }


    @Override
    protected void sendMessage(int index) {
        this.mediator.getMessage(index,name);
    }
}
