package com.yangzhao.java8.generic;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/8/20 11:09
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 *
 * 不是泛型类 实现泛型接口 需要在此就要声明具体的类型
 */
public class SayType2 implements ISayType<String>{
    @Override
    public String getT() {
        return null;
    }

    @Override
    public void setT(String s) {

    }
}
