package com.yangzhao.designPattern.decorate;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/29 14:34
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class BirdCoffee extends AbstractCoffee{
    @Override
    public void say() {
        System.out.println("我是雀巢咖啡");
    }


}
