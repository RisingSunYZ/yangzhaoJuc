package com.yangzhao.designPattern.facade;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/29 17:43
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Facade {

    private Screen screen;
    private Voice voice;


    public Facade() {
        this.screen = Screen.getInstance();
        this.voice = Voice.getInstance();
    }

    public void look(){
        screen.on();
        voice.on();
        voice.up();
    }

    public void unlook(){
        screen.off();
        voice.off();
    }

}
