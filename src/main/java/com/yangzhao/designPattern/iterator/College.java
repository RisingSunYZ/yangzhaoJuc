package com.yangzhao.designPattern.iterator;

import java.util.Iterator;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/14 14:25
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public interface College {

    String getName();

    Iterator createIterator();
}
