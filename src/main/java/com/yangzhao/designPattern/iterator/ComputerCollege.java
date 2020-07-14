package com.yangzhao.designPattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/14 14:37
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class ComputerCollege implements College{

    private List<Department> departments;

    public ComputerCollege() {
        departments = new ArrayList<>();
        departments.add(new Department("计算机科学与技术"));
        departments.add(new Department("数理与计算科学"));
        departments.add(new Department("网络工程"));
        this.departments = departments;
    }

    @Override
    public String getName() {
        return "计算机学院===";
    }

    @Override
    public Iterator createIterator() {
        Iterator iterator = new ComputerIterator(this.departments);
        return iterator;
    }
}
