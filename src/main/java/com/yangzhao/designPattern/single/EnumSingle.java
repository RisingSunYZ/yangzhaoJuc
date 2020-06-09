package com.yangzhao.designPattern.single;

/**
 * @Description:
 * @Author:YangZhao 枚举默认private
 * @Since:2020/6/9 13:49
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public enum EnumSingle{

    SINGLE(new Student());

    private Student stu;

    EnumSingle(){
        System.out.println("EnumSingle...........");
    };

    EnumSingle(Student stu){
        this.stu =  stu;
        System.out.println("EnumSingle...........");
    };

    public Student getStu() {
        return stu;
    }

    public static EnumSingle getSingle(){
        return EnumSingle.SINGLE;
    }
}
