package com.yangzhao.designPattern.memento;

/**
 * @Description:
 * @Author:YangZhao 备忘录模式 我理解 其实也就是把恢复属性的代码给隐藏了，放到了 Hero 中 ，没有暴露给client 单一职责
 * @Since:2020/7/30 17:23
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Test {

    public static void main(String[] args) {

        Hero hero = new Hero(100,100);

        System.out.println(hero);
        Caretaker caretaker = new Caretaker();
        caretaker.setHeroBF(hero.getHeroBF());
        System.out.println("开始打仗，打仗后");
        hero.setDef(80);
        hero.setGjl(80);
        System.out.println(hero);
        System.out.println("卡林塔仙豆恢复。。。。。。。");
        hero.huifu(caretaker.getHeroBF());
        System.out.println(hero);
    }
}
