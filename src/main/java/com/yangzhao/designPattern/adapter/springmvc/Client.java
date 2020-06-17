package com.yangzhao.designPattern.adapter.springmvc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/16 17:55
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Client {
    public static void main(String[] args) {

        List<IDispatchServlet> IDispatchServlet = new ArrayList<>();
        List<Handler> handlers = new ArrayList<>();
        IDispatchServlet.add(new SocketAdapter());
        IDispatchServlet.add(new HttpAdpater());

        Handler h1 = new HttpHandler();
        Handler h2 = new SocketHandler();

        for(IDispatchServlet d:IDispatchServlet){
            if(d.support(h1)){
                handlers.add(h1);
            }
            if(d.support(h2)){
                handlers.add(h2);
            }
        }

        handlers.forEach(h->{
            h.handlerRequest();
        });

    }
}
