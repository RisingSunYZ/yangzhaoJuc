package com.yangzhao.designPattern.memento;

import java.util.Queue;
import java.util.Stack;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/30 17:23
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Caretaker {

    //可以用集合 List  Queue Stack

    private HeroBF heroBF;

    public HeroBF getHeroBF() {
        return heroBF;
    }

    public void setHeroBF(HeroBF heroBF) {
        this.heroBF = heroBF;
    }
}
