package com.yangzhao.java8;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/2/20 15:03
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 *
 * 静态方法不能重写 不具有多态性，子类可以调用父类的静态方法
 *
 */
public class Son extends Father{

  public void work(){//此时不是重写

  }
}
