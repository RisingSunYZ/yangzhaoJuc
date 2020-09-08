package com.yangzhao.java8.generic;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/9/4 16:52
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Temp<T> {

    private Integer code;
    private String msg;

    T data;


    public Integer getCode() {
        return code;
    }

    public Temp setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Temp setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Temp setData(T data) {
        this.data = data;
        return this;
    }
}
