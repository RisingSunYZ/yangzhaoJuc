package com.yangzhao.jvm;

import java.lang.ref.SoftReference;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/2/17 10:02
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有 -Xms10m -Xmx10m -XX:+PrintGCDetails  如果内存够，GC的时候不回收。内存不够，则回收
 */
public class SoftReferenceDemo {

    public static void main(String[] args) {

//        enouchSpace();
        unEnouchSpace();

    }

    private static void unEnouchSpace() {

        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o);

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
        SoftReference<Object> softReference = new SoftReference<>(o);

        System.out.println(o);
        System.out.println(softReference.get());

        System.out.println("=======================");
        o = null;

        System.gc();

        System.out.println(o);
        System.out.println(softReference.get());


    }
}
