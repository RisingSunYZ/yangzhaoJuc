package com.yangzhao.designPattern.decorate;

/**
 * @Description:
 * @Author:YangZhao
 *    InputStream is = new ByteArrayInputStream(new byte[1024]);
 *         new DataInputStream(is);
 * @Since:2020/6/29 14:37
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Test {

    public static void main(String[] args) {

        IDrinks drinks = new BirdCoffee();
        drinks.say();
        drinks.setPrice(5);
        System.out.println(drinks.getPrice());


        IDrinks cole = new Cole(drinks);
        cole.say();
        cole.setPrice(3);
        System.out.println(cole.getPrice());

        IDrinks milk = new Milk(cole);
        milk.say();
        milk.setPrice(4);
        System.out.println(milk.getPrice());
    }

}
