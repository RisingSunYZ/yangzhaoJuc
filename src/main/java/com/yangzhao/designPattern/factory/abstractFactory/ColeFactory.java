package com.yangzhao.designPattern.factory.abstractFactory;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/11 15:20
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class ColeFactory implements Factory {

    @Override
    public IDrinks getMile() {
        return new CocoMilk();
    }

    @Override
    public IDrinks getCole() {
        return new CocoCole();
    }
}
