package com.yangzhao.designPattern.flyweight;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/30 16:36
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class WebSite extends AbstractWebsite
{

    public WebSite(String type) {
        super(type);
    }

    @Override
    protected void use(String use) {
        System.out.println(use+"浏览"+this.type+"网站");
    }
}
