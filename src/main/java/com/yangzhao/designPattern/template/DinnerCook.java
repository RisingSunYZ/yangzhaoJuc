package com.yangzhao.designPattern.template;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/6 16:20
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class DinnerCook extends AbstractCookTemplate{
    @Override
    protected void cooking() {
        System.out.println("做晚饭");
    }

    @Override
    protected boolean isSing() {
        return false;
    }
}
