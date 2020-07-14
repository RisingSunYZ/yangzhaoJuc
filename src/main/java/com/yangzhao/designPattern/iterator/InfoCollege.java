package com.yangzhao.designPattern.iterator;

import java.util.Iterator;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/14 14:26
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class InfoCollege implements College{


    private Department[] departments = new Department[5];

    public InfoCollege() {
        departments[0] = new Department("信息安全");
        departments[1] = new Department("服务器安全");
        departments[2] = new Department("网络安全");
        this.departments = departments;
    }

    @Override
    public String getName() {
        return "信息学院===";
    }

    @Override
    public Iterator createIterator() {
//        Iterator iterator = new InfoMationIterator(this.departments);
//        return iterator;
        return new Itr();
    }

     private final class Itr  implements Iterator {
        private int index = 0;
        @Override
        public boolean hasNext() {
            if(index > departments.length - 1 || null == departments[index]){
                return false;
            }
            return true;
        }

        @Override
        public Object next() {
            return departments[index++];
        }
    }

}
