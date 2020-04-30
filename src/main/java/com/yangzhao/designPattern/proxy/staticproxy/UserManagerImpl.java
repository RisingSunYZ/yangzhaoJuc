package com.yangzhao.designPattern.proxy.staticproxy;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/11 10:36
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class UserManagerImpl implements  UserManager{
    @Override
    public void add() {
        System.out.println("add..............UserManagerImpl");
    }

    @Override
    public void delete() {
        System.out.println("delete..............UserManagerImpl");
    }
}
