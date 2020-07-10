package com.yangzhao.designPattern.visitor;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/10 15:15
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public interface IAction {

    void manScore(AbstractPerson man);

    void womenScore(AbstractPerson woMen);

}
