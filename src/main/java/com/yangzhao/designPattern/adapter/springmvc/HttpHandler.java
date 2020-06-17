package com.yangzhao.designPattern.adapter.springmvc;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/16 17:51
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class HttpHandler extends Handler{
    @Override
    protected void handlerRequest() {
        System.out.println("HttpHandler...........");
    }
}
