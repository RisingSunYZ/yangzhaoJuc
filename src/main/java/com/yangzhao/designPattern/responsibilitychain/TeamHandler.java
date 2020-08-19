package com.yangzhao.designPattern.responsibilitychain;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/8/19 18:51
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class TeamHandler extends VolicationHandler{

    public TeamHandler(String name) {
        super(name);
    }

    @Override
    protected void handler(VolicationRequest volicationRequest) {
        if( volicationRequest.getDay() < 3){
            System.out.println(this.name +"处理");
        }else{
            nextHandler.handler(volicationRequest);
        }
    }

}
