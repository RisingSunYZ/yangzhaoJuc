package com.yangzhao.designPattern.adapter.objectadapter;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/16 18:07
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class DogAdapter  implements IDog {

    private JiaDog JiaDog = new JiaDog();

    @Override
    public int say() {
        return JiaDog.getJiaAge();
    }
}
