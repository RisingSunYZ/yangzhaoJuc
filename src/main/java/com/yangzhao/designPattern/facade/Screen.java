package com.yangzhao.designPattern.facade;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/29 17:40
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Screen {

    private static Screen screen = new Screen();

    public static Screen getInstance(){
        return screen;
    }

    public void on(){
        System.out.println("打开屏幕");
    }


    public void off(){
        System.out.println("关闭屏幕");
    }

    private Screen(){

    };


}
