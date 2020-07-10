package com.yangzhao.designPattern.visitor;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/10 15:13
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public abstract class AbstractPerson {

    private String name;
    private double score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    protected abstract void accept(IAction action);

    public AbstractPerson(String name, double score) {
        this.name = name;
        this.score = score;
    }
}
