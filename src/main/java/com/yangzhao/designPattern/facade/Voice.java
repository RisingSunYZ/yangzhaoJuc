package com.yangzhao.designPattern.facade;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/29 17:41
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Voice {

    private Voice() {
    }

    private static Voice screen = new Voice();

    public static Voice getInstance(){
        return screen;
    }

    public void on(){
        System.out.println("打开音响");
    }

    public void up(){
        System.out.println("调大声音");
    }


    public void off(){
        System.out.println("关闭音响");
    }

}
