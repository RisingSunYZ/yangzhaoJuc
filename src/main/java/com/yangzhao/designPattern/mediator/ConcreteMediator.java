package com.yangzhao.designPattern.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/29 17:08
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class ConcreteMediator extends Mediator{

    private Map<String,Colleague> map = new HashMap<>();

    @Override
    public void registered(String name,Colleague colleague) {
        map.put(name,colleague);
    }

    @Override
    public void getMessage(int index,String name){
        Colleague colleague = map.get(name);
        if(colleague instanceof Curtain){
            if(0 == index){
                Colleague tv = map.get("Tv");
                Colleague coffee = map.get("Coffee");
                ((Coffe)coffee).doCoffee();
                ((Tv)tv).startTv();
            }
        }else if(colleague instanceof Coffe){
            if(0 == index){
                Colleague coffee = map.get("Coffee");
                ((Coffe)coffee).drinkCoffee();
            }
        }



    }
}
