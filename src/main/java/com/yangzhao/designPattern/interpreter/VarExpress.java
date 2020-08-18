package com.yangzhao.designPattern.interpreter;

import java.util.HashMap;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/8/18 14:33
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class VarExpress extends Express{

    private String key;

    public VarExpress(String key) {
        this.key = key;
    }

    @Override
    protected int interpreter(HashMap<String, Integer> var) {
        return var.get(key);
    }
}
