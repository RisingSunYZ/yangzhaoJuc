package com.yangzhao.designPattern.command;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/9 17:02
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 * 个人理解 是一系列操作 或者一些列命令 为了方便调用 统一放到 一个统一实现的接口里 2020年8月19日19:18:07
 */
public class Test {

    public static void main(String[] args) {

        Tv tv = new Tv();
        ICommand onCommand = new TvOnCommond(tv);
        ICommand offCommand = new TvOffCommond(tv);


        RemoteControl eemoteControl = new RemoteControl();
        eemoteControl.setCommand(0,onCommand,offCommand);


        eemoteControl.on(0);
        eemoteControl.unDo();
        eemoteControl.off(0);
        eemoteControl.unDo();


        Refrigerator refrigerator = new Refrigerator();

        ICommand onCommand2 = new RefrigeratorOnCommond(refrigerator);
        ICommand offCommand2 = new RefrigeratorOffCommond(refrigerator);

        eemoteControl.setCommand(1,onCommand2,offCommand2);

        eemoteControl.on(1);
        eemoteControl.unDo();
        eemoteControl.off(1);
        eemoteControl.unDo();


        eemoteControl.on();
        eemoteControl.off();
    }
}
