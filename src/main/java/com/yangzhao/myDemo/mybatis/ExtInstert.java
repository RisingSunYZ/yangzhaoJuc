package com.yangzhao.myDemo.mybatis;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/27 13:08
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExtInstert {

    String value() default "";
}
