package com.yangzhao.designPattern.responsibilitychain;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/8/19 18:47
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public abstract class VolicationHandler {

    protected VolicationHandler nextHandler;

    protected String name;

    public VolicationHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(VolicationHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public VolicationHandler(String name) {
        this.name = name;
    }

    protected abstract void handler(VolicationRequest volicationRequest);

}
