package com.yangzhao.designPattern.command;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/9 16:02
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class TvOffCommond implements ICommand {

    private Tv tv;

    public TvOffCommond(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void excute() {

        this.tv.tvOff();

    }
}
