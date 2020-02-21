package com.yangzhao.jvm;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/2/20 13:36
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class ReferenceQueueDemo {

    public static void main(String[] args) throws Exception{

        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o1,referenceQueue);

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());


        System.out.println("=========================");
        o1 = null;

        System.gc();

        TimeUnit.SECONDS.sleep(1);
        System.out.println(o1);
        System.out.println(weakReference);
        System.out.println(weakReference.get());
        Reference<?> poll = referenceQueue.poll();
        System.out.println(poll);
    }
}
