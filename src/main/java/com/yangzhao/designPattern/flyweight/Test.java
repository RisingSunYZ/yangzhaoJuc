package com.yangzhao.designPattern.flyweight;

/**
 * @Description:
 * @Author:YangZhao 享元模式
 * @Since:2020/6/30 16:40
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Test {

    public static void main(String[] args) {

        WebSiteFactory instance = WebSiteFactory.getInstance();

        AbstractWebsite news = instance.getWebSite("news");
        news.use("tom");

        AbstractWebsite news2 = instance.getWebSite("news");
        news2.use("kobe");

        AbstractWebsite sports = instance.getWebSite("sports");
        sports.use("james");

        AbstractWebsite sports2 = instance.getWebSite("sports");
        sports2.use("jack");

        System.out.println(news == news2);
        System.out.println(sports == sports2);

    }

}
