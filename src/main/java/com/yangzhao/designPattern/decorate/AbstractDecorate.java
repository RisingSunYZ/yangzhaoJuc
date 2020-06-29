package com.yangzhao.designPattern.decorate;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/29 14:35
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public abstract class AbstractDecorate extends IDrinks{

    protected IDrinks drinks;

    public AbstractDecorate(IDrinks drinks) {
        this.drinks = drinks;
    }

    @Override
    public void setPrice(float price) {
        this.price = price + this.drinks.getPrice();
    }
}
