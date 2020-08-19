package com.yangzhao.designPattern.strategy;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/8/19 16:40
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 *
 * 分析出项目中的变与不变
 *
 * 多用聚合 组合 少用继承
 *
 *
 */
public class Test {

    public static void main(String[] args) {

        Context context = new Context(new HadenScorePlayer());
        context.score();

        context = new Context(new CurryScorePlayer());
        context.score();
        context = new Context(new KobeScorePlayer());
        context.score();



    }
}
