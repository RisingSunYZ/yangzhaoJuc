package com.yangzhao.myDemo.mybatis;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/27 13:11
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Log {

    private String id;


    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
