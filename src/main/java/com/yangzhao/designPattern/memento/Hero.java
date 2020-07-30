package com.yangzhao.designPattern.memento;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/30 17:18
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Hero {

    private Integer gjl;
    private Integer def;

    public Hero(Integer gjl, Integer def) {
        this.gjl = gjl;
        this.def = def;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "gjl=" + gjl +
                ", def=" + def +
                '}';
    }

    public Integer getGjl() {
        return gjl;
    }

    public void setGjl(Integer gjl) {
        this.gjl = gjl;
    }

    public Integer getDef() {
        return def;
    }

    public void setDef(Integer def) {
        this.def = def;
    }

    public HeroBF getHeroBF(){
        return HeroBF.build().setDef(def).setGjl(gjl);
    }


    public void huifu(HeroBF heroBF){
        gjl = heroBF.getGjl();
        def = heroBF.getDef();
    }

}
