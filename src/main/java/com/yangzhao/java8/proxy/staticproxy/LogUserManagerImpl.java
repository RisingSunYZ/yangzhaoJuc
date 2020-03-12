package com.yangzhao.java8.proxy.staticproxy;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/11 10:38
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class LogUserManagerImpl implements UserManager{

    private UserManager userManager;

    public LogUserManagerImpl(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public void add() {
        System.out.println("log addd...............begin");
        this.userManager.add();
        System.out.println("log addd...............end");
    }

    @Override
    public void delete() {
        this.userManager.delete();
    }
}
