package com.yangzhao.designPattern.visitor;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/10 15:18
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class FailAction implements IAction{

    @Override
    public void manScore(AbstractPerson man) {
        System.out.println("男人打了失败");
    }

    @Override
    public void womenScore(AbstractPerson woMen) {
        System.out.println("女人打了失败");
    }
}
