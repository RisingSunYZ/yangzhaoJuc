package com.yangzhao.designPattern.builder;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/15 15:51
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public abstract class AbstractBuilder {

    protected Hourse hourse = new Hourse();

    protected abstract void buildFangDing();
    protected abstract void buildWall();
    protected abstract void buildMen();
    protected abstract void buildFloor();
    protected abstract Hourse getHourse();


}
