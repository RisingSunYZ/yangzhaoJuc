package com.yangzhao.designPattern.adapter.springmvc;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/16 17:45
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class HttpAdpater implements IDispatchServlet{

    private HttpHandler HttpHandler = new HttpHandler();

    @Override
    public void handler() {
        HttpHandler.handlerRequest();
    }

    @Override
    public boolean support(Object obj) {
        if(obj instanceof HttpHandler){
            return true;
        }
        return false;
    }
}
