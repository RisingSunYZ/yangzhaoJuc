package com.yangzhao.designPattern.visitor;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/10 15:18
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class SuccessAction implements IAction{

    @Override
    public void manScore(AbstractPerson man) {
        if("刘欢".equals(man.getName())){
            System.out.println("男人打了晋级,分数隐藏");
        }else{
            System.out.println(man.getName()+"打了晋级,分数"+man.getScore());
        }

    }

    @Override
    public void womenScore(AbstractPerson woMen) {
        System.out.println(woMen.getName()+"打了晋级,分数"+woMen.getScore());
    }
}
