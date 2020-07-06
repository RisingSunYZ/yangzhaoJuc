package com.yangzhao.designPattern.template;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/6 16:22
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Test {

    public static void main(String[] args) {
        AbstractCookTemplate dinner = new DinnerCook();
        dinner.cook();

        AbstractCookTemplate launch = new LaunchCooke();
        launch.cook();


    }
}
