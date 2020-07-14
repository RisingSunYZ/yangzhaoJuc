package com.yangzhao.designPattern.observer;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/14 15:51
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class BaiduObserver implements Observer{
    @Override
    public void update() {
        System.out.println("baidu upodate............");
    }
}
