package com.yangzhao.java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/2/9 20:26
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class TestArrayList {

    public static void main(String[] args) {

//        List<Integer> l =new ArrayList<>();
//
//        System.out.println(l.size());
//
//        l.add(1);
//
//
//        System.out.println(l.size());

        testFastFail();
        testFailSafe();

    }


    static void testFailSafe(){

        List<String> l = new CopyOnWriteArrayList<>();
        l.add("1");
        l.add("2");
        l.add("3");


//        for(int i=0;i<l.size();i++){
////            l.add("4");
//
//            l.remove("1");
//            System.out.println(l.get(i));
//        }

        Iterator<String> iterator = l.iterator();

        while(iterator.hasNext()){
//            l.add("4");
            l.remove("2");
//            iterator.remove();

        }
        System.out.println(l);


    }




    static void testFastFail(){

        List<String> l = new ArrayList<>();
        l.add("1");
        l.add("2");
        l.add("3");


//        for(int i=0;i<l.size();i++){
////            l.add("4");
//
//            l.remove("1");
//            System.out.println(l.get(i));
//        }

        Iterator<String> iterator = l.iterator();

        while(iterator.hasNext()){
//            l.add("4");
//            l.remove("2");
            iterator.remove();
            System.out.println(iterator.next());
        }


    }

}
