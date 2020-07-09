package com.yangzhao.designPattern.command;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/9 17:23
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class RefrigeratorOnCommond implements ICommand{

    private Refrigerator refrigerator;

    public RefrigeratorOnCommond(Refrigerator refrigerator) {
        this.refrigerator = refrigerator;
    }

    @Override
    public void excute() {
        refrigerator.refrigeratorOn();
    }
}
