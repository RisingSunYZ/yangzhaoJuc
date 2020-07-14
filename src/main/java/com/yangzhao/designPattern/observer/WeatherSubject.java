package com.yangzhao.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/14 15:50
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class WeatherSubject implements Subject{

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notice() {
        observers.forEach(o->{
            o.update();
        });
    }
}
