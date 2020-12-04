package com.yangzhao.java8.generic;

/**
 * @Description:
 * @Author:YangZhao 泛型类 实现泛型接口 可以在test 里面指定 具体类型
 * @Since:2020/8/20 10:19
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class SayType<T> implements ISayType<T>{


    //泛型方法 其实与泛型类没啥关系
    public static <T>T getInstance(T t){
        return t;
    }

//静态方法不能使用类上的泛型
//    public static T test(T t){
//
//    }



    //泛型方法 其实与泛型类没啥关系
    public static <T> Temp<T> getInstance666(){
        Temp<T> remp = new Temp<>();
        return remp.setCode(1).setMsg("1");
    }

    //泛型方法
    public static <U>U getInstance2(U t){
        return t;
    }

    public  T getInstance3(T t){
        return t;
    }


    public  T getInstance5(Class<T> t) throws IllegalAccessException, InstantiationException {
        return t.newInstance();
    }

    public  <T>T getInstance6(Class<T> t) throws IllegalAccessException, InstantiationException {
        return t.newInstance();
    }

    public  <E>E getInstance4(E t){
        return t;
    }

    @Override
    public T getT() {
        return null;
    }

    @Override
    public void setT(T t) {

    }
}
