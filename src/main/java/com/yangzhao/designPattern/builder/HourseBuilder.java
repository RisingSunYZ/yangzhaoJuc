package com.yangzhao.designPattern.builder;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/15 15:52
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class HourseBuilder extends AbstractBuilder {
    @Override
    protected void buildFangDing() {
        this.hourse.setFangding("普通房子建房顶");
        System.out.println("普通房子建房顶");
    }

    @Override
    protected void buildWall() {
        this.hourse.setWall("普通房子建墙");
        System.out.println("普通房子建墙");
    }

    @Override
    protected void buildMen() {
        this.hourse.setMen("普通房子建门");
        System.out.println("普通房子建门");
    }

    @Override
    protected void buildFloor() {
        this.hourse.setFloor("普通房子建地板");
        System.out.println("普通房子建地板");
    }

    @Override
    protected Hourse getHourse() {
        return this.hourse;
    }
}
