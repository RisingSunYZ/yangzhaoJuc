package com.yangzhao.designPattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/10 15:28
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class ChinaVoice {

    private List<AbstractPerson> list = new ArrayList<>();

    public void add(AbstractPerson person){
        list.add(person);
    }


    public void score(IAction action){
        list.forEach(c->{
            c.accept(action);
        });
    }


}
