package com.yangzhao.designPattern.interpreter;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/8/18 14:34
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public abstract class SynbolExpress extends Express{

    protected Express left;

    protected Express right;

    public SynbolExpress(Express left, Express right) {
        this.left = left;
        this.right = right;
    }

}
