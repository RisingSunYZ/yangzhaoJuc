package com.yangzhao.designPattern.mediator;

/**
 * @Description:
 * @Author:YangZhao 中介者模式 ，我感觉这种模式吧 也就解决了不同操作类之间的彼此耦合，每个业务类只需要关心自己的方法，但是 中介类的getMessage方法 属实有点.....
 * @Since:2020/7/29 17:03
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Tv extends Colleague{

    public Tv(String name, Mediator mediator) {
        super(name, mediator);
        this.mediator.registered(name,this);
    }

    public void startTv(){
        System.out.println("打开电视");
    }


    @Override
    protected void sendMessage(int index) {
    }
}
