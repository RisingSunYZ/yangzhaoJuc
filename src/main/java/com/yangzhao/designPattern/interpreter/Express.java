package com.yangzhao.designPattern.interpreter;

import java.util.HashMap;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/8/18 14:33
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public abstract class Express {

    protected abstract int interpreter(HashMap<String, Integer> var);
}
