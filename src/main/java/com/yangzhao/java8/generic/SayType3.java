package com.yangzhao.java8.generic;


/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/8/20 11:11
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class SayType3 {

    //报错
//    public T getInstance3(T t){
//        return t;
//    }

    public <T>T getInstance4(T t){
        return t;
    }



}
