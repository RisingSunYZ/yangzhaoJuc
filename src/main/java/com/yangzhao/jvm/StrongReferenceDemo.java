package com.yangzhao.jvm;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/2/17 9:49
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 * 使用new方法创造出来的对象，默认都是强引用。GC的时候，就算内存不够，抛出OutOfMemoryError也不会回收对象，死了也不回收
 */
public class StrongReferenceDemo {


    public static void main(String[] args) throws Exception{
        Object o1 = new Object();
        Object o2 = new Object();


        try{
            o1 = null;
            System.gc();
            byte[] b = new byte[1024*1024*15];
        }catch (Exception e){

        }finally {
            System.out.println(o2);
        }


    }
}
