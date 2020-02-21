package com.yangzhao.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/2/20 13:44
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class PhantomReferenceDemo {

    public static void main(String[] args) throws Exception{

        String s = new String("123");
//        String s = "123"; 不可以
        ReferenceQueue<String> ReferenceQueue = new ReferenceQueue<>();
        PhantomReference<String> phantomReference = new PhantomReference<>(s,ReferenceQueue);

        System.out.println(s);
        System.out.println(phantomReference.get());
        System.out.println(ReferenceQueue.poll());

        System.out.println("==========================");

        s = null;
        System.gc();
        TimeUnit.SECONDS.sleep(1);

        System.out.println(s);
        String s1 = phantomReference.get();
        System.out.println(s1);
        Reference<? extends String> poll = ReferenceQueue.poll();
        System.out.println(poll);



    }
}
