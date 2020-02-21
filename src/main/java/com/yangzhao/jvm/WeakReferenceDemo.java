package com.yangzhao.jvm;

import java.lang.ref.WeakReference;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/2/20 11:40
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有  无论内存够不够，GC的时候都回收
 */
public class WeakReferenceDemo {


    public static void main(String[] args) {

//        enouchSpace();
        unEnouchSpace();

    }

    private static void unEnouchSpace() {

        Object o = new Object();
        WeakReference<Object> softReference = new WeakReference<>(o);

        System.out.println(o);
        System.out.println(softReference.get());
        System.out.println("=====================");
        o = null;

        try{
            byte[] arr = new byte[15*1024*1024];
            System.gc();
        }catch (Exception e){

        }finally {
            System.out.println(o);
            System.out.println(softReference.get());
        }





    }

    private static void enouchSpace() {

        Object o = new Object();
        WeakReference<Object> softReference = new WeakReference<>(o);

        System.out.println(o);
        System.out.println(softReference.get());

        System.out.println("=======================");
        o = null;

        System.gc();

        System.out.println(o);
        System.out.println(softReference.get());


    }
}
