package com.yangzhao.jvm.oom;

import java.nio.ByteBuffer;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/2/21 10:45
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 *
 * 在写NIO程序的时候，会用到ByteBuffer来读取和存入数据。与Java堆的数据不一样，ByteBuffer使用native方法，直接在堆外分配内存。当堆外内存（也即本地物理内存）不够时，就会抛出这个异常
 */
public class DirectBufferMemoryDemo {

    public static void main(String[] args) {
        System.out.println("配置的maxDirectMemory: " + (sun.misc.VM.maxDirectMemory() / (double) 1024 / 1024) + "MB");
        //什么都不配 3627m
        // -Xms10m -Xmx10m  -XX:+PrintGCDetails 9.5M
        try {
            Thread.sleep(300);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }
}
