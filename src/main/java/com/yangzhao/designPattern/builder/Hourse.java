package com.yangzhao.designPattern.builder;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/15 16:00
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Hourse {

    private String fangding;

    private String wall;

    private String floor;

    private String men;

    @Override
    public String toString() {
        return "Hourse{" +
                "fangding='" + fangding + '\'' +
                ", wall='" + wall + '\'' +
                ", floor='" + floor + '\'' +
                ", men='" + men + '\'' +
                '}';
    }

    public String getFangding() {
        return fangding;
    }

    public void setFangding(String fangding) {
        this.fangding = fangding;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getMen() {
        return men;
    }

    public void setMen(String men) {
        this.men = men;
    }
}
