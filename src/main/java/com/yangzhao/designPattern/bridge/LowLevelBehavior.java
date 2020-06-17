package com.yangzhao.designPattern.bridge;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/17 10:36
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class LowLevelBehavior implements IBehavior{
    @Override
    public void score() {
        System.out.println("我是低水平运动员,我得分少");
    }

    @Override
    public void getMoney() {
        System.out.println("我是低水平运动员,我赚钱少");
    }
}
