package com.yangzhao.designPattern.observer;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/14 15:52
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Test {


    public static void main(String[] args) {
        Subject subject = new WeatherSubject();

        Observer observer = new BaiduObserver();
        Observer observer2 = new SinaObserver();
        subject.add(observer);
        subject.add(observer2);
        subject.remove(observer2);
        subject.notice();

    }
}
