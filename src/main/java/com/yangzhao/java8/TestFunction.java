package com.yangzhao.java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/1/13 10:49
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class TestFunction {

    public static void main(String[] args) {
//        sayHellow(()->"helloWorld");
//        sayHellow(()->123);
//
//        sayHellow2(e-> {
//            System.out.println(e);
//            System.out.println(e.getClass().getName());
//        },"123");

//        sayHellow3(e-> {
//            return e+"test";
//        },"yz");

        sayHellow4(e-> {
           return e.equals("123");
        },"yz");

    }


    static void sayHellow(Supplier<? extends Object> supplier){
        System.out.println(supplier.get());
    }

    static void sayHellow2(Consumer<? super String> customer,String e){
        customer.accept(e);
    }

    static void sayHellow3(Function<? super String,String> function, String e){
        System.out.println(function.apply(e));
    }

    static void sayHellow4(Predicate<String> predicate, String e){
        System.out.println(predicate.test(e));
    }

}
