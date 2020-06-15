package com.yangzhao.designPattern.builder;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/15 15:54
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Director {

    private AbstractBuilder abstractBuilder;

    public Director(AbstractBuilder abstractBuilder) {
        this.abstractBuilder = abstractBuilder;
    }

    public Hourse build(){
        abstractBuilder.buildFloor();
        abstractBuilder.buildWall();
        abstractBuilder.buildMen();
        abstractBuilder.buildFangDing();
        return abstractBuilder.getHourse();
    }

}
