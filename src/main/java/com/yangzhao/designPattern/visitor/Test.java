package com.yangzhao.designPattern.visitor;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/10 15:32 绕脑袋
 * @Version:1.1.0 双分派, 数据结构稳定的作为被访问者
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Test {


    public static void main(String[] args) {


        ChinaVoice chinaVoice = new ChinaVoice();

        AbstractPerson man = new Man("刘欢",90);
        AbstractPerson women = new WoMen("那英",80);
        chinaVoice.add(man);
        chinaVoice.add(women);


        chinaVoice.score(new SuccessAction());
        chinaVoice.score(new FailAction());

    }
}
