package com.yangzhao.designPattern.builder;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/15 15:53
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class LouBuilder extends AbstractBuilder{
    @Override
    protected void buildFangDing() {
        this.hourse.setFangding("楼建房顶");
        System.out.println("楼建房顶");
    }

    @Override
    protected void buildWall() {
        this.hourse.setWall("楼建墙");
        System.out.println("楼建墙");
    }

    @Override
    protected void buildMen() {
        this.hourse.setMen("楼建门");
        System.out.println("楼建门");
    }

    @Override
    protected void buildFloor() {
        this.hourse.setFloor("楼建地板");
        System.out.println("楼建地板");
    }

    @Override
    protected Hourse getHourse() {
        return this.hourse;
    }
}
