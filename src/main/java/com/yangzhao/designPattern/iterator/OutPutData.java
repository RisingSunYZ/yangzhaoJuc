package com.yangzhao.designPattern.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/14 14:40
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class OutPutData {

    private List<College> colleges;


    public OutPutData(List<College> colleges) {
        this.colleges = colleges;
    }

    public void outPut(){
        colleges.forEach(c->{
            System.out.println(c.getName());
            Iterator iterator = c.createIterator();
            while(iterator.hasNext()){
                Department next = (Department)iterator.next();
                System.out.println(next.getName());
            }

        });
    }

}
