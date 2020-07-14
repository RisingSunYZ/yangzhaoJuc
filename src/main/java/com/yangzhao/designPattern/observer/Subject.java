package com.yangzhao.designPattern.observer;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/14 15:48
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public interface Subject {


    void add(Observer observer);

    void remove(Observer observer);

    void notice();

}
