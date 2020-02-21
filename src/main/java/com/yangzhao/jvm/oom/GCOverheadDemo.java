package com.yangzhao.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/2/21 10:26
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 *
 * 超过98%的时间用来做GC并且回收了不到2%的堆内存时会抛出此异常
 *查看项目中是否有大量的死循环或有使用大内存的代码，优化代码  大对象？ 一个对象所占内存越来越大？
 *
 *
 *
 */
public class GCOverheadDemo {

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();

        while(true){
            l.add(String.valueOf(Math.random()));
        }


    }
}
