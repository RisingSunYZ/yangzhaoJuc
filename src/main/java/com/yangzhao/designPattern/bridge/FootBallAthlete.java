package com.yangzhao.designPattern.bridge;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/17 10:34
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class FootBallAthlete extends AbstractAthlete{



    public FootBallAthlete(IBehavior behavior) {
        super(behavior);
    }

    @Override
    protected void score() {
        System.out.println("我是足球运动员");
        super.score();
    }

    @Override
    protected void getMoney() {
        System.out.println("我是足球运动员");
        super.getMoney();
    }
}
