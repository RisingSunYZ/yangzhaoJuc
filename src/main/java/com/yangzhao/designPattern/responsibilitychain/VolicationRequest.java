package com.yangzhao.designPattern.responsibilitychain;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/8/19 18:49
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class VolicationRequest {

    private Integer day;


    public VolicationRequest(Integer day) {
        this.day = day;
    }


    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}
