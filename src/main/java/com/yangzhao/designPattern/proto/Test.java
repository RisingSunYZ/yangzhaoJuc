package com.yangzhao.designPattern.proto;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/11 17:45
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Test {

    public static void main(String[] args) throws Exception{

        Person p = new Person(12,"Tony",new Person(13,"Jemy",null));

//        Person clone = (Person)p.clone();
//        Person clone1 = (Person)p.clone();
//        Person clone2= (Person)p.clone();
        Person clone = p.myClone();
        Person clone1 = p.myClone();
        Person clone2 = p.myClone();

        System.out.println(clone);
        System.out.println(clone1);
        System.out.println(clone2);

        System.out.println(clone == clone1);
        System.out.println(clone == clone2);

    }
}
