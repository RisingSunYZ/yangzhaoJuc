package com.yangzhao.designPattern.strategy;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/8/19 16:37
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class KobeScorePlayer implements ScorePlayer{
    @Override
    public void score() {

        System.out.println("我是科比，我得两分");

    }
}
