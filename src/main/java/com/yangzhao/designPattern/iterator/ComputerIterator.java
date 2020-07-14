package com.yangzhao.designPattern.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/14 14:20
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class ComputerIterator implements Iterator {


    private List<Department> departments;
    int index = 0;

    public ComputerIterator(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if(index > departments.size() - 1){
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
     return departments.get(index++);
    }
}
