package com.yangzhao.juc;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCollection {

    public static void main(String[] args) {
//        testList();

        testMap();
    }

    private static void testMap() {
        //Hashtable
        Map<String,String> map = new HashMap<>();
        Map<String,String> map1 = new ConcurrentHashMap<>();


        for(int i=0;i<100;i++){
            new Thread(()->{

                map.put(UUID.randomUUID().toString(),UUID.randomUUID().toString());
                System.out.println(Thread.currentThread().getName() + "========>" + map);
                System.out.println(Thread.currentThread().getName() + "========>" + map.size());
            },i+"").start();
        }


//        for(int i=0;i<10;i++){
//            new Thread(()->{
//                map1.put(UUID.randomUUID().toString(),UUID.randomUUID().toString());
//                System.out.println(Thread.currentThread().getName() + "========>" + map1);
//                System.out.println(Thread.currentThread().getName() + "========>" + map1.size());
//            },i+"").start();
//        }
    }


    private static void testList() {


//            List<String> l = new ArrayList<>();

//        for (int i = 0; i < 100; i++) {
//                new Thread(() -> {
//                    l.add(UUID.randomUUID().toString());
//                System.out.println(l);
//                System.out.println(l.size());
//                },i+"").start();
//            }


//        Vector<String> Vector = new Vector<>();
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                Vector.add(UUID.randomUUID().toString());
//                System.out.println(Thread.currentThread().getName()+"========>"+Vector);
//                System.out.println(Thread.currentThread().getName()+"========>"+Vector.size());
//            },i+"").start();
//        }

//        List<String> strings = Collections.synchronizedList(l);
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                strings.add(UUID.randomUUID().toString());
//                System.out.println(Thread.currentThread().getName()+"========>"+strings);
//                System.out.println(Thread.currentThread().getName()+"========>"+strings.size());
//            },i+"").start();
//        }


        CopyOnWriteArrayList<String> CopyOnWriteArrayList = new CopyOnWriteArrayList();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                CopyOnWriteArrayList.add(UUID.randomUUID().toString());
                System.out.println(Thread.currentThread().getName() + "========>" + CopyOnWriteArrayList);
                System.out.println(Thread.currentThread().getName() + "========>" + CopyOnWriteArrayList.size());
            }, i + "").start();
        }

    }

}
