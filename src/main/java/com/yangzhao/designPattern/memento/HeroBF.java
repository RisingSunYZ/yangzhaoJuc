package com.yangzhao.designPattern.memento;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/30 17:18
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class HeroBF {

    private Integer gjl;
    private Integer def;


    public static HeroBF build(){
        return new HeroBF();
    }

    public Integer getGjl() {
        return gjl;
    }

    public HeroBF setGjl(Integer gjl) {
        this.gjl = gjl;
        return this;
    }

    public Integer getDef() {
        return def;
    }

    public HeroBF setDef(Integer def) {
        this.def = def;
        return this;
    }
}
