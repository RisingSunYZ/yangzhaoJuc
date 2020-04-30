package com.yangzhao.juc;

import com.yangzhao.designPattern.builder.UserBuilder;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/1/4 16:46
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class ABAAtomicRefrence {

    public static void main(String[] args) {
        UserBuilder build = new UserBuilder.InnerUser().setAdress("jianshan").setName("yangzhao").build();
        UserBuilder build1 = UserBuilder.getBuilder().setName("zhuwenling").setAdress("taihu").build();
        AtomicReference<UserBuilder> AtomicReference = new AtomicReference();
        AtomicReference.set(build);
        boolean b = AtomicReference.compareAndSet(build, build1);
        System.out.println(b);
        System.out.println(AtomicReference.get());

        boolean b1 = AtomicReference.compareAndSet(build, build1);
        System.out.println(b1);
        System.out.println(AtomicReference.get());


    }

}
