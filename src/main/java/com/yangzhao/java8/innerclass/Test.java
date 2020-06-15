package com.yangzhao.java8.innerclass;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/15 17:10
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Test {

    public static void main(String[] args) {

        //创建内部类必先创建外部类
        Father father = new Father();
        Father.Son son = father.new Son();

//        //内部类可以访问父类任何属性 包括私有
//        System.out.println(son.getFatherName());
//        System.out.println(son.getMyName());
        son.sayFatherInfo();


        //静态内部类只能访问  父类静态属性
//        Father.Daughter daughter = new Father.Daughter();
        Father.Daughter daughter = Father.getMyDaughter();//推荐使用这种方式获取成员内部类
//        System.out.println(daughter.getFatherAge());
//        System.out.println(daughter.getMyName());
////        System.out.println(daughter.getMyAge());
//        System.out.println( Father.Daughter.getMyAge());
        daughter.sayFatherInfo();

        FlyAndRun flyAndRun = new FlyAndRun();
        flyAndRun.fly();
        flyAndRun.run();

    }
}
