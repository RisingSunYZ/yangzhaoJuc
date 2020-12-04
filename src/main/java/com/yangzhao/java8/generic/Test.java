package com.yangzhao.java8.generic;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/8/20 10:20
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Test {


    public static void main(String[] args) throws Exception{

        SayType<Integer> sat = new SayType();


        sat.setT(1);

        sat.getT();

        sat.getInstance3(123);
        sat.getInstance4("123");
        //要使用显示声明泛型
        SayType.<Double>getInstance(11.d);//报错

        //类型推断
        int i = SayType2.test2(1);

//显示声明泛型
        //SayType2.<String>test2(1);

        SayType.getInstance666().setData(123);
        //SayType.<String>getInstance666().setData(123);//报错
        SayType.getInstance("123");//其实与泛型类 指定的类型无关

        sat.getInstance5(Integer.class);
        String a1 = SayType.getInstance("1");

        sat.getInstance6(String.class);






        SayType3 sat3 = new SayType3();
//Integer a = sat3.getInstance3(1);报错

        Integer a = sat3.getInstance4(1);//可以

    }
}
