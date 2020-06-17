package com.yangzhao.designPattern.bridge;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/17 10:34
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public abstract class AbstractAthlete {

    private IBehavior behavior;

    protected void score(){
        this.behavior.score();
    };

    protected void getMoney(){
        this.behavior.getMoney();
    };

    public AbstractAthlete(IBehavior behavior) {
        this.behavior = behavior;
    }
}
