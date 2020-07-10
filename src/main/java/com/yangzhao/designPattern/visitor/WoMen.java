package com.yangzhao.designPattern.visitor;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/10 15:14
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class WoMen extends AbstractPerson{

    public WoMen(String name, double score) {
        super(name, score);
    }

    @Override
    protected void accept(IAction action) {
        action.womenScore(this);
    }
}
