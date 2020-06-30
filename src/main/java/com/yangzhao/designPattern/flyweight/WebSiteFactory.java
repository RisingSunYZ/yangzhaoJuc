package com.yangzhao.designPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/30 16:38
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class WebSiteFactory {

    private final Map<String,AbstractWebsite> temp = new HashMap<>();

    private WebSiteFactory() {
    }

    private static WebSiteFactory WebSiteFactory = new WebSiteFactory();

    public static WebSiteFactory getInstance(){
        return WebSiteFactory;
    }

    public AbstractWebsite getWebSite(String s){
        if(temp.containsKey(s)){
            return temp.get(s);
        }
        WebSite w = new WebSite(s);
        temp.put(s,w);
        return w;
    }


}
